
import java.util.Scanner;

public class Smoots 
{
    public static void main(String[] args) 
    {
        Smoots smoots = new Smoots();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number of centimetres as a double!");
        
        double length = sc.nextDouble();
        smoots.calcSmoots(length);
        sc.close();
    }

    public void calcSmoots(double length) 
    {
        double smootLength = 170.00;
        double smoots = length / smootLength;

        System.out.printf("Total number of smoots: %.2f", smoots);
    }
}
