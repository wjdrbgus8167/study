import java.io.*;
import java.util.*;


class Main 
{
	
	static boolean visited[];
	static int arr[][];
	static int n;
	public static void main(String[] args)throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		
		for(int i=0;i<m;i++)
		{
			st= new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1; 
		}
		int cnt=0;
		for(int i=1;i<=n;i++)
		{
			if(!visited[i])
			{
				dfs(i);
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
	}
	public static void dfs(int x )
	{
		
		visited[x] = true;
		for(int i=1;i<=n;i++)
		{
			if(arr[x][i]==1&&!visited[i])
			{
				dfs(i);
			}
		}
	}
	
}