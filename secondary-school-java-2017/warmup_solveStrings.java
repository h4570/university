import java.util.Scanner;

public class warmup_solveStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int counter=0;
        for(int i=1;i<=n;i++){
            for(int x=1;x<n-counter;x++){System.out.print(' ');}
            for(int y=0;y<i;y++){System.out.print('#');}
            System.out.print("\n");
            counter++;
        }
    }

}
