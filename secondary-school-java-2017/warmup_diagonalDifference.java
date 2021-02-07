import java.util.Scanner;

public class warmup_diagonalDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        int firstDiagonalOffset = 0,secondDiagonalOffset = n-1,firstDiagonal = 0,secondDiagonal = 0,secondCounter=0;
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
                if(firstDiagonalOffset--==0){firstDiagonalOffset=n;firstDiagonal+= a[a_i][a_j];}
                if(secondDiagonalOffset--==0 && secondCounter <n){secondDiagonalOffset=n-2;secondDiagonal+= a[a_i][a_j];secondCounter++;}
            }
        }
        int number = firstDiagonal-secondDiagonal;
        System.out.println(number < 0 ? -number : number);
    }

}
