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
    		String P = br.readLine();
    		String Q = br.readLine();
    		if(P.charAt(0)<Q.charAt(0))
    		{
    			sb.append("#"+testcase+" "+"Y").append("\n");
    		}else {
    			for(int i=97;i<=122;i++)
        		{
        			char c = (char)97;
        			String a = P+c;
        			if(!a.equals(Q))
        			{
        				sb.append("#"+testcase+" "+"Y").append("\n");
        				break;
        			}else {
        				sb.append("#"+testcase+" "+"N").append("\n");
        				break;
        			}
        		}
     
    		}
    	}
    	System.out.println(sb);
    }
}