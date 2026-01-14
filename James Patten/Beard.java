public class Beard
{
    public static void main(String[] args)
    {
        Beard beard = new Beard();
        beard.calcBeard(5.18);
    }

    public void calcBeard(double beardLength) 
    {
        double conversion = beardLength * 1000;
        double total = conversion / 55.5;
        int hours = (int) Math.round(total);

        System.out.println("Total number of hours taken to grow: " + hours);
    }
}