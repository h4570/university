import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String,Integer> myMap = new HashMap<String,Integer>(); 
        for(int i = 0; i < n; i++){
            String name = in.next();
            Integer phone = in.nextInt();
            myMap.put(name, phone);	
        }
        while(in.hasNext()){
            String s = in.next();
            Integer result = myMap.get(s);
            if(result!=null){System.out.println(s+"="+result);}
            else{System.out.println("Not found");}
        }
        in.close();
    }
}
