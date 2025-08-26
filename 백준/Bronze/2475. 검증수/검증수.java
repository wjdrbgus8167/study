import java.io.*;
import java.util.*;

class Main{
    
    public static void main(String[] args)throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int sum =0;
        
        for(int i=1;i<=5;i++){
            int x = Integer.parseInt(st.nextToken());
            
            sum += Math.pow(x,2);
        }
        
        System.out.println(sum%10);
    }
}