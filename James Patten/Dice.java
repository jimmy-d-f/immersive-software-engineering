import java.util.*;
public class Dice 
{
    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) 
    {
        Dice dice = new Dice();
        
        int sides = dice.findFaces();
        int diceCount = dice.Dices();
        int total = dice.rollDice(sides, diceCount);
        System.out.println("Total number added: " + total);
    }

    public int findFaces() 
    {
        System.out.println("Please enter the number of sides for the dice:");
        int sides = scanner.nextInt();
        return sides;
    }

    public int Dices() 
    {
        System.out.println("How many dice do you want to roll?");
        int diceCount = scanner.nextInt();
        return diceCount;
    }

    public static int rollDice(int sides, int dice) 
    {
        int total = 0;
        Random random = new Random();
        System.out.println("Rolling " + dice + " dice, with " + sides + ":");
        for (int i = 0; i < dice; i++) 
        {
            int roll = random.nextInt(sides) + 1;
            System.out.println("Die " + (i + 1) + ": " + roll);
            total += roll;
        }
        return total;
    }
}