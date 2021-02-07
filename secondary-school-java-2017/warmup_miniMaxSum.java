import java.util.Scanner;

public class warmup_miniMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        long minimum=0,maximum=0,all=0;
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
            all+=arr[arr_i];
            if(minimum>arr[arr_i] || maximum==0){minimum=arr[arr_i];}
            if(maximum<arr[arr_i]){maximum=arr[arr_i];}
        }
        System.out.println(all-maximum+" "+(all-minimum));
    }

}
