import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        double[] results = {10,15,20,40,40,60,30,20,19,30,100,87,79};
        
        Arrays.sort(results);
        
        double target = 30;
        int index = Arrays.binarySearch(results, target);
        
        System.out.println("The target was: " + target + " and it was reached at index " + index + ".");
        
        double pos = 100 - ((double)index / results.length * 100);
        
        System.out.printf("\nThe passing grade was: %.2f percent.", pos);
    }
}
