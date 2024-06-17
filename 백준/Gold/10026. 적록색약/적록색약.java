import java.io.*;
import java.util.*;


class Main{
	
	static char arr[][];
	static int n;
	static boolean visited[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	public static void main(String []args )throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		arr = new char[n][n];
		visited = new boolean[n][n];
		
		for(int i =0;i<n;i++)
		{
			String s = br.readLine();
			
			for(int j=0;j<n;j++)
			{
				arr[i][j]= s.charAt(j);
			}
		}
		StringBuilder sb = new StringBuilder();
		int count=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i][j]=='R'&&!visited[i][j])
				{
					dfs(i,j);
					count++;
				}else if(arr[i][j]=='B'&&!visited[i][j])
				{
					Bdfs(i,j);
					count++;
				}else if(arr[i][j]=='G'&&!visited[i][j])
				{
					Gdfs(i,j);
					count++;
				}
			}
		}
		sb.append(count).append(" ");
		
		count=0;
		visited = new boolean[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if((arr[i][j]=='R'||arr[i][j]=='G')&&!visited[i][j])
				{
					RGdfs(i,j);
					count++;
				}else if(arr[i][j]=='B'&&!visited[i][j])
				{
					Bdfs(i,j);
					count++;
				}
			}
		}
		sb.append(count);
		System.out.println(sb);
		
		
	}
	public static void dfs(int x,int y)
	{
		visited[x][y] = true;
		
		for(int i=0;i<4;i++)
		{
			int kx = dx[i]+x;
			int ky = dy[i]+y;
			
			if(kx>=0&&ky>=0&&kx<n&&ky<n)
			{
				if(arr[kx][ky]=='R'&&!visited[kx][ky])
				dfs(kx,ky);
			}
		}
	}
	public static void Bdfs(int x,int y)
	{
		
		visited[x][y] = true;
		
		for(int i=0;i<4;i++)
		{
			int kx = dx[i]+x;
			int ky = dy[i]+y;
			
			if(kx>=0&&ky>=0&&kx<n&&ky<n)
			{
				if(arr[kx][ky]=='B'&&!visited[kx][ky])
				Bdfs(kx,ky);
			}
		}
	}
	public static void Gdfs(int x,int y)
	{
		
		visited[x][y] = true;
		
		for(int i=0;i<4;i++)
		{
			int kx = dx[i]+x;
			int ky = dy[i]+y;
			
			if(kx>=0&&ky>=0&&kx<n&&ky<n)
			{
				if(arr[kx][ky]=='G'&&!visited[kx][ky])
				Gdfs(kx,ky);
			}
		}
	}
	public static void RGdfs(int x,int y)
	{
		
		visited[x][y] = true;
		
		for(int i=0;i<4;i++)
		{
			int kx = dx[i]+x;
			int ky = dy[i]+y;
			
			if(kx>=0&&ky>=0&&kx<n&&ky<n)
			{
				if((arr[kx][ky]=='G'||arr[kx][ky]=='R')&&!visited[kx][ky])
				RGdfs(kx,ky);
			}
		}
	}
	
}