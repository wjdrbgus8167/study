import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

class Solution{
	
	 public static void main(String[] args)throws IOException 
    {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int t = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	for(int testcase=1;testcase<=t;testcase++)
    	{
    		int n = Integer.parseInt(br.readLine());
    		int score = 0;
    		StringTokenizer st ;
    		
    		for(int i=0;i<n;i++)
    		{
    			st= new StringTokenizer(br.readLine()," ");
    			
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			double x = Math.sqrt(a*a+b*b);
    			
    			
    		
    			int radius = (int) Math.ceil(x / 20); 
                int points = 11 - radius; 
                score += Math.max(0, Math.min(10, points));
    			
    		}
    		sb.append("#"+testcase+" "+score).append("\n");
    	}
    	System.out.println(sb);
    }
    
}