import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
	

	public static void main(String[] args)throws IOException{
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
		 int t = Integer.parseInt(br.readLine());
	      
		 StringBuilder sb = new StringBuilder();
	  
	     for(int testcase = 1; testcase <= t; testcase++) 
	     {
	    	String s = br.readLine();
	    	int len = s.length();
	    	s = s.substring(0,3);
	    	
	    	int snum = Integer.parseInt(s);
	    	snum = (int)Math.round(snum/10.0);
	    	
	    	 if(snum == 100) 
	    	 {
	              System.out.println("#" + testcase + " " + String.format("%.1f", snum / 100.0) + "*10^"  + (len));
	              continue;
	          }
	            
	    	 System.out.println("#" + testcase + " " + String.format("%.1f", snum / 10.0) + "*10^" + (len-1));
	        
	    	
	     }
	      
		
	}
	
	
}