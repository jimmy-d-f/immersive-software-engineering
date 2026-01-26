import java.util.stream.IntStream;

public class BinarySearch 
{
    public static int binarySearch(int[] a, int target)
    {
        int left = 0;
        int right = a.length - 1;

        while (left <= right)
        {
            int mid = (left + right) / 2;
            
            if (a[mid] == target) return mid + 1;

            else if (a[mid] < target) left = mid - 1;

            else right = mid + 1;

        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[] a = IntStream.rangeClosed(1, 10000).toArray();
        int target = 100;

        long start = System.nanoTime(); 
        int result = binarySearch(a, target);
        long stop = System.nanoTime();

        long durationNs = stop - start;
        double duration = (double) durationNs / 1000000;
        System.out.println("Runtime: " + duration + " ms");

        if (result != -1) System.out.println("Found element at: " + result);

        else System.err.println("Result not found!");
    }
}
