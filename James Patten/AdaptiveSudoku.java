import java.util.*;

/**
 * Adaptive Sudoku (console)
 * - Generates a new random puzzle every game.
 * - Difficulty auto-adjusts based on time + mistakes.
 * - Console output is laid out to be easy to read.
 */
public class AdaptiveSudoku {

    private static final String RESET   = "\u001B[0m";
    private static final String BG1     = "\u001B[47m"; // light box
    private static final String BG2     = "\u001B[46m"; // slightly different box

    private static final int SIZE  = 9;
    private static final int EMPTY = 0;

    private static final Random RANDOM = new Random();

    private enum Difficulty {
        EASY, MEDIUM, HARD
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Difficulty difficulty = Difficulty.EASY;

        printWelcome();

        while (true) {
            // Build a fresh solution and puzzle
            int[][] solution = generateFullBoard();
            int[][] puzzle   = generatePuzzle(solution, difficulty);
            boolean[][] given = markGivenCells(puzzle); // remember which cells are original givens

            int mistakes = 0;
            long start   = System.currentTimeMillis();

            while (!isComplete(puzzle)) {
                printStatusBar(difficulty);
                printBoard(puzzle, given);

                System.out.println("Enter move as: row col value (1-9)");
                System.out.println("Example: 3 7 9  -> set row 3, col 7 to 9");
                System.out.println("Or type: 0 0 0 to give up.");
                System.out.print("Your move: ");

                int row = scanner.nextInt();
                int col = scanner.nextInt();
                int val = scanner.nextInt();

                if (row == 0 && col == 0 && val == 0) {
                    System.out.println();
                    System.out.println("You gave up. Here is the solution:");
                    printBoard(solution, null);
                    mistakes += 5;
                    break;
                }

                if (!isValidInput(row, col, val)) {
                    System.out.println("Invalid input. Rows/cols/values must be 1-9.");
                    System.out.println();
                    continue;
                }

                row--;
                col--;

                if (given[row][col]) {
                    System.out.println("That cell is a given; it cannot be changed.");
                    System.out.println();
                    continue;
                }

                if (solution[row][col] == val) {
                    puzzle[row][col] = val;
                } else {
                    System.out.println("Incorrect value.");
                    System.out.println();
                    mistakes++;
                }
            }

            long end       = System.currentTimeMillis();
            double seconds = (end - start) / 1000.0;

            System.out.printf("%nFinished. Time: %.1f seconds, mistakes: %d%n", seconds, mistakes);

            difficulty = adjustDifficulty(difficulty, seconds, mistakes);
            System.out.println("Next game difficulty will be: " + difficulty);
            System.out.println();

            System.out.print("Play again? (y/n): ");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("y")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }
            System.out.println();
        }

        scanner.close();
    }

    // ---------------------------------------------------------------------
    // Game helpers
    // ---------------------------------------------------------------------

    private static void printWelcome() {
        System.out.println("==============================================");
        System.out.println("            Adaptive Sudoku (Console)         ");
        System.out.println("==============================================");
        System.out.println("Controls:");
        System.out.println(" - Use numbers 1..9 for rows and columns.");
        System.out.println(" - Given numbers are shown like [5].");
        System.out.println(" - Your own numbers are shown like 5.");
        System.out.println(" - Empty cells are shown as .");
        System.out.println();
    }

    private static boolean isValidInput(int row, int col, int val) {
        return row >= 1 && row <= 9 &&
               col >= 1 && col <= 9 &&
               val >= 1 && val <= 9;
    }

    private static void printStatusBar(Difficulty difficulty) {
        System.out.println("----------------------------------------------");
        System.out.print  ("Difficulty: " + difficulty + " | ");
        switch (difficulty) {
            case EASY:
                System.out.println("Target: finish in < 3 min, few mistakes.");
                break;
            case MEDIUM:
                System.out.println("Target: finish in ~5–8 min.");
                break;
            case HARD:
                System.out.println("Target: take your time; puzzles are sparse.");
                break;
        }
        System.out.println("----------------------------------------------");
    }

    private static Difficulty adjustDifficulty(Difficulty current,
                                               double timeSec,
                                               int mistakes) {
        final double FAST_TIME   = 180.0; // 3 minutes
        final double SLOW_TIME   = 600.0; // 10 minutes
        final int    FEW_MISTAKES  = 2;
        final int    MANY_MISTAKES = 6;

        if (timeSec < FAST_TIME && mistakes <= FEW_MISTAKES) {
            if (current == Difficulty.EASY)  return Difficulty.MEDIUM;
            if (current == Difficulty.MEDIUM) return Difficulty.HARD;
        } else if (timeSec > SLOW_TIME || mistakes >= MANY_MISTAKES) {
            if (current == Difficulty.HARD)  return Difficulty.MEDIUM;
            if (current == Difficulty.MEDIUM) return Difficulty.EASY;
        }

        return current;
    }

    private static boolean[][] markGivenCells(int[][] puzzle) {
        boolean[][] given = new boolean[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                given[r][c] = (puzzle[r][c] != EMPTY);
            }
        }
        return given;
    }

    // ---------------------------------------------------------------------
    // Board generation
    // ---------------------------------------------------------------------

    private static int[][] generateFullBoard() {
        int[][] board = new int[SIZE][SIZE];
        fillBoard(board);
        return board;
    }

    private static boolean fillBoard(int[][] board) {
        int[] pos = findEmpty(board);
        if (pos == null) {
            return true;
        }

        int row = pos[0];
        int col = pos[1];

        List<Integer> numbers = new ArrayList<>();
        for (int n = 1; n <= 9; n++) {
            numbers.add(n);
        }
        Collections.shuffle(numbers, RANDOM);

        for (int num : numbers) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (fillBoard(board)) {
                    return true;
                }
                board[row][col] = EMPTY;
            }
        }
        return false;
    }

    private static int[][] generatePuzzle(int[][] solution, Difficulty diff) {
        int[][] puzzle = copyBoard(solution);

        int removeCount;
        switch (diff) {
            case EASY:
                removeCount = 35; // about 46 clues
                break;
            case MEDIUM:
                removeCount = 45; // about 36 clues
                break;
            case HARD:
                removeCount = 55; // about 26 clues
                break;
            default:
                removeCount = 40;
        }

        List<int[]> cells = new ArrayList<>();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                cells.add(new int[]{r, c});
            }
        }
        Collections.shuffle(cells, RANDOM);

        int removed = 0;
        for (int[] cell : cells) {
            if (removed >= removeCount) {
                break;
            }
            int r = cell[0];
            int c = cell[1];

            if (puzzle[r][c] != EMPTY) {
                puzzle[r][c] = EMPTY;
                removed++;
            }
        }

        return puzzle;
    }

    // ---------------------------------------------------------------------
    // Board utilities
    // ---------------------------------------------------------------------

    private static int[] findEmpty(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] == EMPTY) {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int c = 0; c < SIZE; c++) {
            if (board[row][c] == num) {
                return false;
            }
        }
        for (int r = 0; r < SIZE; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[boxRow + r][boxCol + c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isComplete(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] copyBoard(int[][] src) {
        int[][] dst = new int[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            dst[r] = Arrays.copyOf(src[r], SIZE);
        }
        return dst;
    }

    /**
     * Print the board with:
     * - coordinate labels (R1..R9, C1..C9)
     * - [x] for given cells
     * - x   for user cells
     * - .   for empty cells
     */
    private static void printBoard(int[][] board, boolean[][] given) {
        System.out.println();

        for (int r = 0; r < SIZE; r++) {
            System.out.print("          "); // left margin

            for (int c = 0; c < SIZE; c++) {
                int value = board[r][c];

                // choose background by 3x3 box, to create thin colored boxes
                boolean boxEven = ((r / 3) + (c / 3)) % 2 == 0;
                String bg = boxEven ? BG1 : BG2;

                String cellText;
                if (value == EMPTY) {
                    cellText = "   ";          // empty cell: just spaces
                } else {
                    cellText = " " + value + " "; // number centered in 3 chars
                }

                System.out.print(bg + cellText + RESET);
            }
            System.out.println();
        }

        System.out.println();
    }   
}