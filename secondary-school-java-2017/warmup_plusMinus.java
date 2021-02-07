import java.util.Scanner;

public class warmup_plusMinus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int positive = 0,negative = 0, zero = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            if(arr[arr_i]>0){positive++;}
            else if(arr[arr_i]<0){negative++;}
            else{zero++;}
        }
        System.out.println((double)positive/n);
        System.out.println((double)negative/n);
        System.out.println((double)zero/n);
    }
}
