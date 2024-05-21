import java.io.*;
import java.util.*;
 
class Main{
	static char wood[][];
	static boolean visited[][];
	static int n;
	static int m;
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n][m];
		
		wood = new char[n][m];
		for(int i=0;i<n;i++)
		{
			String s = br.readLine();
			for(int j=0;j<m;j++)
			{
				wood[i][j]= s.charAt(j);
			}
		}
		int count=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(visited[i][j])
					continue;
				if(wood[i][j]=='-')
				{
					dfs(i,j,true);
				}else {
					dfs(i,j,false);
				}
				count++;
			}
		}
		System.out.println(count);
		
	}
	
	private static void dfs(int i,int j,boolean row)
	{
		visited[i][j] =true;
		
		if(row) {
			j++;
			if(j<m&&wood[i][j]=='-')
			{
				dfs(i,j,true);
			}
		}else {
			i++;
			if(i<n&&wood[i][j]!='-')
				dfs(i,j,false);
		}
	}
}