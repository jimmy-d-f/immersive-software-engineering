import java.util.*;

public class AddOne {
    public static void main(String[] args) {
        int[] number = {1,2,3,4,5};
        System.out.println("Result: " + Arrays.toString(number));
        addOne(number);
        System.out.println("Result: " + Arrays.toString(number));

    }

    public static void addOne(int number[]) {
        for (int i = 0; i < number.length; i++) {
            number[i]++;
        }
    }
}