import java.util.*;

public class MagicSquares 
{
    public static void main(String[] args) 
    {
        int number;
    
        while (true) 
        {
            System.out.println("\nThis program will generate a magic square of a specified odd size.");
            System.out.println("Please enter an odd integer for the size of the magic square:");
            
            Scanner scanner = new Scanner(System.in);
            
            number = scanner.nextInt();

            if (number % 2 == 0 || number < 1) 
            {
                System.out.println("Error: The size must be an odd integer and it must be greater than 0. \nPlease try again:");
                continue;
            }
            break;
        }

        int [][] magicSquare = new int[number][number];
        int row = 0;
        int col = number / 2;
        for (int i = 1; i <= number * number; i++) 
        {
            magicSquare[row][col] = i;

            int newRow = (row - 1);
            int newCol = (col + 1);

            if (newCol == number) newCol = 0;
            if (newRow < 0) newRow = number - 1;

            if (magicSquare[newRow][newCol] != 0) 
            {
                newRow = (row + 1) % number;
                newCol = col;
            }

            row = newRow;
            col = newCol;
        }

        /*
        int [][] magicSquare = new int[number][number];
        int row = 0;
        int col = number / 2;
        magicSquare[row][col] = 1;
        for (int i = 2; i <= number * number; i++) 
        {
            int newRow = (row - 1 + number) % number;
            int newCol = (col + 1) % number;

            if (magicSquare[newRow][newCol] != 0) 
            {
                newRow = (row + 1) % number;
            }
            
            row = newRow;
            col = newCol;
            magicSquare[row][col] = i;
        }
        */

        System.out.println("\n\nThe magic square of size " + number + " is:");
        for (int i = 0; i < number; i++)
        {
            for (int j = 0; j < number; j++) 
            {
                System.out.printf("%4d", magicSquare[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nThe total number of each row is: " + number * (number * number + 1) / 2);
        System.out.println("The total number of each column is: " + number * (number * number + 1) / 2);
        System.out.println("The total number of each diagonal is: " + number * (number * number + 1) / 2);
        System.out.println("The total number of the entire square is: " + (number * number * (number * number + 1)) / 2);
        
        System.out.printf("\nThank you for using the magic square generator!");
    }
}   
