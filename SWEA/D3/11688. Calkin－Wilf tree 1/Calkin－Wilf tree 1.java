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
    		String s = br.readLine();
    		int a = 1;
    		int b = 1;
    		for(int j=0;j<s.length();j++)
    		{
    			if(s.charAt(j)=='L')
    			{
    				a = a;
    				b = a+b;
    			}else if(s.charAt(j)=='R'){
    				a = a+b;
    				b = b;
    			}
    		}
    		sb.append("#"+testcase+" "+a+" "+b).append("\n");
    		
    	}
    	System.out.println(sb);
    }
}