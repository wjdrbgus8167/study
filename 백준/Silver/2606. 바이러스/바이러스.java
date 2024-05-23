import java.io.*;
import java.util.*;


class Main{
	
	static boolean visited[];
	static int arr[][];
	static int count=0;
	static int t,n;
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		visited= new boolean[t+1];
		arr = new int[t+1][t+1];
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=n;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a]=1;
			
		}
		dfs(1);
		
		
		System.out.println(count-1);
	}
	
	public static void dfs(int x)
	{
		visited[x] = true;
		count +=1;
		
		for(int i=1;i<=t;i++)
		{
			
			if(arr[x][i]==1&&!visited[i])
			{
			
				dfs(i);
			}
		}
	}
}