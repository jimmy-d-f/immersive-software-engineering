import java.util.*;

public class Sicbo 
{
    public static void main(String[] args) 
    {
        Sicbo sicbo = new Sicbo();
        Random r = new Random();

        sicbo.printSicbo(sicbo.playSicbo());
    }

    public void runSicbo() 
    {
        for (int i = 0; i < 1000; i++) 
        {
            playSicbo();
        }
    }

    public int playSicbo() 
    {
        int number = 0;
        for (int i = 0; i < 1000; i++) 
        {
            Random r = new Random();
            int die1 = r.nextInt(6) + 1;
            int die2 = r.nextInt(6) + 1;
            int die3 = r.nextInt(6) + 1;

            int total = die1 + die2 + die3;

            if (total > 10 && die1 != die2 && die2 != die3 && die1 != die3) 
            {
                number++;
            } 
        }
        
        return number;
    }

    public void printSicbo(int number) 
    {
        double winRate = (number / 1000.0) * 100;
        System.out.println("Win Rate: " + winRate + "%");
    }
}