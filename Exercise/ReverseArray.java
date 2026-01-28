import java.util.*;

public class ReverseArray
{

    public static void main(String[] args)
    {
        System.out.println("Give me an array, separated by commas.");
        Scanner sc = new Scanner(System.in);
        String array = sc.nextLine();
        String[] parts = array.split(",");

        int Length = parts.length;
        int[] nums = new int[Length];
        for (int i = 0; i < Length; i++)
        {
            nums[i] = Integer.parseInt(parts[i].trim());
        }

        System.out.println("\nThank you! Now please give me the shifting value.");
        int k = sc.nextInt();
        sc.close();

        rotate(nums, k);

        System.out.println("The changed array is: " + Arrays.toString(nums));
    }

    public static int[] rotate(int[] nums, int k) 
    {
        int length = nums.length;
        int wrap = k % length;

        if (length == 0) return nums;
        if (wrap == 0) return nums;

        reverse(nums, 0, length - 1);
        reverse(nums, 0, wrap - 1);
        reverse(nums, wrap, length - 1);

        return nums;
    }

    private static void reverse(int[] nums, int l, int r) 
    {
        while(l < r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}