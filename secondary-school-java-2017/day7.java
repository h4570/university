import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            String firstPart = "";            
            String secondPart = "";
            char[] word = in.next().toCharArray();
            for(int x=0;x<word.length;x++){
               if((x+1)%2==1){firstPart+=word[x];}
               else{secondPart+=word[x];}
            }
            System.out.println(firstPart+" "+secondPart);
        }
    }
}
