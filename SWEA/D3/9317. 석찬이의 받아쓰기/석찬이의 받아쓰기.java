import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;

class Solution{
	
	public static int result;
	
	public static void main(String[] args)throws IOException{
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
		 int t = Integer.parseInt(br.readLine());
	      
		 StringBuilder sb = new StringBuilder();
	  
		 for(int testcase=1;testcase<=t;testcase++)
		 {
			 int n = Integer.parseInt(br.readLine());
			 
			 String s = br.readLine();
			 String ns = br.readLine();
			 int count=0;
			 for(int i=0;i<n;i++)
			 {
				 if(s.charAt(i)==ns.charAt(i))
				 {
					 count++;
				 }
			 }
			 sb.append("#"+testcase+" "+count+"\n");
		 }
		 System.out.println(sb);
	}
	
}