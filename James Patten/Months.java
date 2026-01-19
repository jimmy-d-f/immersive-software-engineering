public class Months 
{
    public static void main(String[] args) 
    {
        int[][] months = new int[12][];

        months[0] = new int[] {31}; 
        months[1] = new int[] {28}; 
        months[2] = new int[] {31}; 
        months[3] = new int[] {30}; 
        months[4] = new int[] {31}; 
        months[5] = new int[] {30};
        months[6] = new int[] {31};
        months[7] = new int[] {31}; 
        months[8] = new int[] {30}; 
        months[9] = new int[] {31}; 
        months[10] = new int[] {30}; 
        months[11] = new int[] {31}; 

        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        System.out.printf("%-10s %s\n", "Month", "Days");
        System.out.println("-------------------");
        for (int i = 0; i < months.length; i++) 
        {
            System.out.printf("%-10s %d\n", monthNames[i], months[i][0]);
        }
    }
}
