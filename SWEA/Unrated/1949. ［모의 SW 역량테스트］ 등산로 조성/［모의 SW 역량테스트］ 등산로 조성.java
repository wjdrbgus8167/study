

import java.io.*;
import java.util.*;

public class Solution {

	static int[][] mt;
	
	static int K;
	static int N;
	static int dx[] = {1,0,-1,0};
	static int dy[]= {0,1,0,-1};
	static boolean visited[][];
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t= Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testcase =1;testcase<=t;testcase++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			mt = new int[N][N];
			visited = new boolean[N][N];
			
			int max=0;
			
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
				{
					int a = Integer.parseInt(st.nextToken());

					mt[i][j] =a;
					max = Math.max(max, a);
				}
			}
			
			
			int result=0;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(mt[i][j]==max)
					{
						visited = new boolean[N][N];
						result = Math.max(result,dfs(i,j,max,1,false));
						
					}
				}
			}
			
			sb.append("#"+testcase+" "+result).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int dfs(int x, int y,int mountain,int depth,boolean check)
	{
		visited[x][y] =true;
		int maxdepth =depth;
		
		for(int i=0;i<4;i++)
		{
			int k1= dx[i]+x;
			int k2 =dy[i]+y;
			
			if(k1>=0&&k1<N&&k2>=0&&k2<N&&!visited[k1][k2])
			{
				
				int height =mt[k1][k2];
				if(mountain>mt[k1][k2])
				{
					maxdepth = Math.max(maxdepth,dfs(k1,k2,mt[k1][k2],depth+1,check));
				}else if(!check && mt[k1][k2] - K < mountain) {
					maxdepth = Math.max(maxdepth, dfs(k1, k2, mountain-1, depth+1, true));
				}

				
				
			}
			
		}
		visited[x][y] =false;
		return maxdepth;
	}
	

}
