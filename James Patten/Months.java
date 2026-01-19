public class Months 
{
    public static void main(String[] args) 
    {
        double[][] months = new double[12][];

        months[0] = new double[] {31}; 
        months[1] = new double[] {28}; 
        months[2] = new double[] {31}; 
        months[3] = new double[] {30}; 
        months[4] = new double[] {31}; 
        months[5] = new double[] {30};
        months[6] = new double[] {31};
        months[7] = new double[] {31}; 
        months[8] = new double[] {30}; 
        months[9] = new double[] {31}; 
        months[10] = new double[] {30}; 
        months[11] = new double[] {31}; 
    
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        System.out.printf("%-10s %s%n", "Month", "Days");
        System.out.println("-------------------");
        for (int i = 0; i < months.length; i++) 
        {
            System.out.printf("%-10s %.0f%n", monthNames[i], months[i][0]);
        }
    }
}
