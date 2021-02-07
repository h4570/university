import java.util.Scanner;

public class day3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();

        // Write your calculation code here.
        double tip = 12.0*(tipPercent/100.00);
        double tax = 12.0*(taxPercent/100.00);

        // cast the result of the rounding operation to an int and save it as totalCost
        int totalCost = (int) Math.round(mealCost)+(int)Math.round(tip+tax);
        System.out.println("The total meal cost is "+totalCost+" dollars.");
        // Print your result
    }

}
