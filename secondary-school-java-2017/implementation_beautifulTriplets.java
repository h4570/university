import java.util.HashSet;
import java.util.Scanner;

public class implementation_beautifulTriplets {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();

        System.out.println("Please,enter amount of numbers :");
        int size = scan.nextInt();
        System.out.println("Enter magicNumber:");
        int magicNumber = scan.nextInt();
        int result = 0;
        System.out.println("Enter numbers (separating by enter):");
        for(int i=0;i<size;i++) {
            int freshNumber = scan.nextInt();
            if (set.contains(freshNumber - magicNumber) && set.contains((freshNumber - magicNumber) - magicNumber)) {
                result++;
            }
            set.add(freshNumber);
        }
        System.out.println(result);
        scan.close();
    }

}
