import java.util.stream.IntStream;

public class Linear_and_BinarySearch 
{
    public static void main(String[] args) 
    {
        int[] a = IntStream.rangeClosed(1, 10000).toArray();
        int target = 100;
        long Lstart = System.nanoTime(); 
        int Lresult = linearSearch(a, target);
        long Lstop = System.nanoTime();

        long LdurationNs = Lstop - Lstart;
        double Lduration = (double) LdurationNs / 1000000;
        System.out.println("Linear search runtime: " + Lduration + " ms");

        
        if (Lresult != -1) System.out.println("Found element " + Lresult);
        else System.err.println("Could not find element!");

        long Bstart = System.nanoTime(); 
        int Bresult = binarySearch(a, target);
        long Bstop = System.nanoTime();

        long BdurationNs = Bstop - Bstart;
        double Bduration = (double) BdurationNs / 1000000;
        System.out.println("\nBinary search runtime: " + Bduration + " ms");

        if (Bresult != -1) System.out.println("Found element " + Bresult);
        else System.err.println("Could not find element!");
    }

    public static int linearSearch(int[] a, int target)
    {
            for (int i = 1; i < a.length; i++)
            {
                if (a[i] == target) return i + 1;
            }

            return -1;
    }

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
}
