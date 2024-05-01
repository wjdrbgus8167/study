import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

class Solution{
	
	public static char arr[][];
	public static int n;
	public static int[] dr = {-1,-1,0,1,1,1,0,-1};
	public static int[] dc = {0,1,1,1,0,-1,-1,-1};
	public static boolean sign;
	
    public static void main(String[] args)throws IOException 
    {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int t = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	for(int testcase=1;testcase<=t;testcase++)
    	{
    		n  =Integer.parseInt(br.readLine());
    		arr= new char[n][n];
    		
    		for(int i=0;i<n;i++)
    		{
    			String s = br.readLine();
    			for(int j=0;j<n;j++)
    			{
    				arr[i][j]= s.charAt(j);
    			}
    			
    		}
    		sign = false;
    		
    		for(int i=0;i<n;i++)
    		{
    			for(int j=0;j<n;j++)
    			{
    				if(arr[i][j]=='o')
    				{
    					for(int a =0;a<8;a++)
    					{
    						for(int count=1;count<5;count++)
    						{
    							int nr = i+dr[a]*count;
    							int nc = j+dc[a]*count;
    							
    							if(nr<0||nc<0||nr>=n||nc>=n)
    								break;
    							else if(arr[nr][nc]!='o')
    								break;
    							
    							if(count==4)
    								sign =true;
    						}
    					}
    				}
    			}
    		}
    		if(sign)
    		{
    			sb.append("#"+testcase+" "+"YES").append("\n");
    		}else {
    			sb.append("#"+testcase+" "+"NO").append("\n");
    		}
    		
    	}
    	System.out.println(sb);
    }
    
}