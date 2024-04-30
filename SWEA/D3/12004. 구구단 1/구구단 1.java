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
    	for(int i=1;i<=t;i++)
    	{
    		int a = Integer.parseInt(br.readLine());
    		boolean flag = false;
    		for(int j=1;j<=9;j++)
    		{
    			for(int k=1;k<=9;k++)
    			{
    				if(k*j==a)
    				{
    					flag = true;
    					break;
    				}
    			}
    		}
    		if(flag)
    		{
    			sb.append("#"+i+" "+"Yes").append("\n");
    		}else {
    			sb.append("#"+i+" "+"No").append("\n");
    		}
    	}
    	System.out.println(sb);
    }
}