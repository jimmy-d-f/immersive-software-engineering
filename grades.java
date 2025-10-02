import java.util.ArrayList;

public class Grades
{
    public static void main(String[] args)
    {
        ArrayList<Double> grades = new ArrayList<Double>();

        grades.add(45.5);
        grades.add(55.5);
        grades.add(65.5);
        grades.add(75.5);
        grades.add(85.5);

        grades.set(1, 40.0);
        grades.remove(4);

        System.out.println("The grades are:\n");
        double total = 0.0;

        for (int i = 0; i < grades.size(); i++)
        {
            System.out.println(grades.get(i));
            total += grades.get(i);
        }

        double average = total / grades.size();
        System.out.println("\nThe average grade is: " + average);
    }
}
