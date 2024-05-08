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
	  
	     for(int testcase = 1; testcase<= t; testcase++) 
	     {
	    	 int n= Integer.parseInt(br.readLine());
	    	 result =0;
	    	 boolean[][] arr = new boolean[n][26];
	    	 for(int i=0;i<n;i++)
	    	 {
	    		 char[] str =br.readLine().toCharArray();
	    		 for(int j=0;j<str.length;j++)
	    		 {
	    			 arr[i][str[j]-'a'] =true;
	    		 }
	    	 }
	    	 dfs(0,n,arr,new int[26]);
	    	 sb.append("#"+testcase+" "+result+"\n");
	     }
	     System.out.println(sb);
	
	}
	public static void dfs(int depth,int count, boolean[][] arr,int[] check)
	
	{
		if(depth==count)
		{
			int flag =0;
			for(int i=0;i<check.length;i++)
			{
				if(check[i]>=1)
				{
					flag++;
				}
			}
			if(flag==26)
			{
				result++;
			}
			return ;
		}
		
		for(int j=0;j<arr[depth].length;j++)
		{
			if(arr[depth][j]) {
				check[j]++;
				}
		}
		dfs(depth+1,count,arr,check);
		for(int j=0;j<arr[depth].length;j++)
		{
			if(arr[depth][j])
			{
				check[j]--;
			}
		}
		dfs(depth+1,count,arr,check);
	}
}