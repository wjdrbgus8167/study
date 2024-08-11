import java.io.*;
import java.util.*;

public class Solution {

	static int weight[];
	static int N;
	static int count=0;
	static boolean visited[];
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1;testcase<=T;testcase++)
		{
			N= Integer.parseInt(br.readLine());
			weight = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				weight[i] = Integer.parseInt(st.nextToken());
			}
			count=0;
			visited = new boolean[N];
			dfs(0,0,0);
			sb.append("#"+testcase+" "+count).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int idx,int leftsum, int rightsum)
	{
		if(idx==N-1)
		{
			count++;
			for(int i=0;i<N;i++)
			{
				if(!visited[i]&&leftsum>=rightsum+weight[i])
				{
					count++;
				}
			}
			return;
		}
		
		for(int i=0;i<N;i++)
		{
			if(!visited[i])
			{
				visited[i] = true;
				dfs(idx+1,leftsum+weight[i],rightsum);
				
				if(rightsum+weight[i]<=leftsum)
				{
					dfs(idx+1,leftsum,rightsum+weight[i]);
				}
				visited[i] =false;
			}
			
			
		}
		
	}
	
}