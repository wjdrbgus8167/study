import java.io.*;
import java.util.*;


class Main 
{
	static char arr[][] ;
	static boolean visited[][];
	static int dx[]= {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int n;

	static int dep=0;
	public static void main(String[] args)throws IOException{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		arr = new char[n][n];
		visited = new boolean[n][n];
		
		for(int i=0;i<n;i++)
		{
			String s = br.readLine();
			for(int j=0;j<n;j++)
			{
				arr[i][j] = s.charAt(j);
			}
		}
		int count=0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i][j]=='1'&&!visited[i][j])
				{
					count++;
					dfs(i,j,count);
					list.add(dep);
					dep=0;
				}
			}
		}
		
		
		sb.append(count).append("\n");
		Collections.sort(list);
		for(int a:list)
		{
			sb.append(a).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int x,int y,int idx)
	{
		if(arr[x][y]=='1'&&!visited[x][y])
		{
			visited[x][y] =true;
			dep++;
		}
		
		for(int i=0;i<4;i++)
		{
			int c1 = x+dx[i];
			int c2 = y+dy[i];
			if(c1>=n||c2>=n||c1<0||c2<0||arr[c1][c2]=='0'||visited[c1][c2])
			{
				continue;
			}
			dfs(c1,c2,idx);
		}
	}
}