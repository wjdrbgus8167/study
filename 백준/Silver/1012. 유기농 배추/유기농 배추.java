import java.io.*;
import java.util.*;


class Main 
{
	static int arr[][];
	static boolean visited[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int m;
	static int n;
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t= Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase=0;testcase<t;testcase++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			m= Integer.parseInt(st.nextToken());
			n =Integer.parseInt(st.nextToken());
			int cabbage = Integer.parseInt(st.nextToken());
			
			arr = new int[m][n];
			visited = new boolean[m][n];
			
			
			for(int i=0;i<cabbage;i++)
			{
				st= new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a][b] = 1;
			}
			int count=0;
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(arr[i][j]==1&&!visited[i][j])
					{
						
						dfs(i,j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
			
		}
		System.out.println(sb);
	}
	public static void dfs(int i,int j)
	{
	
		visited[i][j]=true;
		
		for(int x=0;x<4;x++)
		{
			int idx = i+dx[x];
			int idy = j+dy[x];
			
			if(idx>=0&&idy>=0&&idx<m&&idy<n)
			{
				if(!visited[idx][idy]&&arr[idx][idy]==1)
					{
					dfs(idx,idy);
					}
			}
		}
	}
}