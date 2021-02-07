import java.util.Scanner;

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
        }
        in.close();
        String result="";
        for(int i=n-1; i >= 0; i--){
            result+=arr[i]+" ";
        }
        System.out.println(result);
    }
