import java.util.Scanner;

public class implementation_gradingStudents {

    static int[] solve(int[] grades,int n){
        for(int grades_i=0; grades_i < n; grades_i++){
            if(grades[grades_i]>=38){
                if(grades[grades_i]%5!=0){
                    int multiplier=10;
                    for(;grades[grades_i]>multiplier;multiplier+=10){}
                    if(multiplier-grades[grades_i]==6||multiplier-grades[grades_i]==7){grades[grades_i]=multiplier-5;}
                    else if(multiplier-grades[grades_i]<3){grades[grades_i]=multiplier;}
                }
            }
        }
        return grades;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades,n);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }

}
