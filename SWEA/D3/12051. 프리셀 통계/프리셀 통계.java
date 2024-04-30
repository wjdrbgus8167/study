import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution{
	

    public static void main(String[] args)throws IOException 
    {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int t = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	for(int testcase=1;testcase<=t;testcase++)
    	{
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		long n = Long.parseLong(st.nextToken());
    		int pd = Integer.parseInt(st.nextToken());
    		int pg = Integer.parseInt(st.nextToken());
    		
    		boolean flag =false;
    		if(pd !=0&&pg==0)
    		{
    			sb.append("#"+testcase+" "+"Broken").append("\n");
    			
    		}else if(pd!=100&&pg==100)
    		{
    			sb.append("#"+testcase+" "+"Broken").append("\n");
    			
    		}else {
    			
    			for (int i = 1; i <= n; i++) 
    			{  	
    				if ((i * pd)/100==(i * pd)/100.0 ) 
    			    {
    			        flag = true;
    			        break;
    			    }
    			}
    			if(flag==true)
        		{
        			sb.append("#"+testcase+" "+"Possible").append("\n");
        		}else {
        			sb.append("#"+testcase+" "+"Broken").append("\n");
        		}
    		}
    		
    		
    	}
    	System.out.println(sb);
    }
}