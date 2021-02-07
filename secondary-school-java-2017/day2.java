import java.util.Scanner;

public class day2 {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int secondInt = 0;
        double secondDouble = 0.0;
        String secondString = "";

        /* Read and save an integer, double, and String to your variables.*/
        secondInt = scan.nextInt();
        secondDouble = scan.nextDouble();
        secondString = scan.next() + scan.nextLine();
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

        /* Print the sum of both integer variables on a new line. */
        System.out.println(i+secondInt);
        /* Print the sum of the double variables on a new line. */
        System.out.println(d+secondDouble);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.println(s+secondString);

        scan.close();
    }

}
