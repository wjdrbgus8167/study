import java.io.*;
import java.util.*;
 
public class Solution {
   
	public static void main(String[] args) throws Exception {
        
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase=1;testcase<=t;testcase++)
		{
			long n = Integer.parseInt(br.readLine());
			
			long before_cnt = (n-1)*(n-1);
			long layer_cnt = 2*n-1;
			
			long a = (2*before_cnt+1);
			long b = a+2*(layer_cnt-1);
			
			sb.append("#"+testcase+" "+a+" "+b+"\n");
			
		}
		
		System.out.println(sb);
    }
 
  
}