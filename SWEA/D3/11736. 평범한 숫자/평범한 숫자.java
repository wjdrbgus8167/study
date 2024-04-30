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
    		int arr[] = new int[n+1];
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		for(int i=1;i<=n;i++)
    		{
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		int count=0;
    		for(int j=2;j<=n-1;j++)
    		{
    			if(arr[j]<arr[j-1]&&arr[j]>arr[j+1])
    			{
    				count++;
    			}else if(arr[j]>arr[j-1]&&arr[j]<arr[j+1])
    			{
    				count++;
    			}
    		}
    		sb.append("#"+testcase+" "+count).append("\n");
    	}
    	System.out.println(sb);
    }
}