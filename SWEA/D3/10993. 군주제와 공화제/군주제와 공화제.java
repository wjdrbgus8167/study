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
    	
    	for(int testcase =1;testcase<=t;testcase++)
    	{
    		int n =Integer.parseInt(br.readLine());
    		int arr[][] = new int[n][3];
    		String result[] = new String[n];
    		for(int i=0;i<n;i++)
    		{
    			StringTokenizer st = new StringTokenizer(br.readLine()," ");
    			for(int j=0;j<3;j++)
    			{
    				arr[i][j]= Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		
    		
    		for(int i=0;i<n;i++)
    		{
    			
    			int w = 0;
    			double max = 0;
    			
    			for(int j=0;j<n;j++)
    			{
    				if(i==j)
    				{
    					continue;
    				}else {
    					double distance=(Math.pow(arr[j][0]-arr[i][0],2)+Math.pow(arr[j][1]-arr[i][1],2));
    					double y = (double)arr[j][2]/distance;
    					if(arr[i][2]<y)
    					{
    						if(max<y)
            				{
            					w=j+1;
            					max = y;
            				}else if(max ==y) {
            					w=n+1;
            				}
    					}
    						
    				}
    				
    			}
    			
    			if(w==0){
    				result[i] ="K";
    			}else if(w!=n+1)
    			{
    				result[i]=Integer.toString(w);
    			}else {
    				result[i] ="D";
    			}
    				
    		}
    		int v=0;
    		for(int k=0;k<n;k++)
    		{
    			if(result[k]!="K"&&result[k]!="D")
    			{
    				v =Integer.parseInt(result[k])-1;
    				
    				while(result[Integer.parseInt(result[k])-1]!="K" && result[Integer.parseInt(result[k])-1]!="D")
    				{
    					result[k] = result[Integer.parseInt(result[k])-1];
    				}
    			}
    			
    		}
    		sb.append("#"+testcase+" ");
    		for(int z=0;z<n;z++)
    		{
    			sb.append(result[z]+" ");
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb);
    }
    
}