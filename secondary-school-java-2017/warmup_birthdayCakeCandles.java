import java.util.Scanner;

public class warmup_birthdayCakeCandles {

    static int birthdayCakeCandles(int n, int[] ar) {
        int tallest=0;
        int count=0;
        for(int ar_i = 0; ar_i < n; ar_i++){
            if(ar[ar_i]>tallest){tallest=ar[ar_i];count=0;}
            if(ar[ar_i]==tallest){count++;}
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }

}
