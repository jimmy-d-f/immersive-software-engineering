import java.util.stream.IntStream;

public class LinearSearch 
{
    public static void main(String[] args) 
    {
        int[] a = IntStream.rangeClosed(1, 10000).toArray();
        int target = 100;
        long start = System.nanoTime(); 
        int result = linearSearch(a, target);
        long stop = System.nanoTime();

        long durationNs = stop - start;
        double duration = (double) durationNs / 1000000;
        System.out.println("Runtime: " + duration + " ms");

        if (result != -1) System.out.println("Found element " + result);
        else System.err.println("Could not find element!");
    }

    public static int linearSearch(int[] a, int target)
    {
            for (int i = 1; i < a.length; i++)
            {
                if (a[i] == target) return i;
            }

            return -1;
    }
}
