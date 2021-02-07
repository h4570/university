import java.util.Scanner;

public class warmup_timeConversion {

    static String timeConversion(String s) {
        String result="";
        int hours=Integer.parseInt(s.substring(0,2));
        if(s.substring(8).equals("PM")){
            if(hours<12){hours+=12;}
            result=hours+":"+s.substring(3,8);
        }else{
            if(hours>11){result="00"+s.substring(2,8);}
            else{result=s.substring(0,8);}
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }

}
