import java.io.*;
import java.util.*;


class Main{
	
	static int r,c;
	static char arr[][];
	static boolean visited[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int count=0;
	static int maxcount =0;
	static ArrayList<Character> list = new ArrayList<>();
	
	public static void main(String []args )throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i=0;i<r;i++)
		{
			String s = br.readLine();
			for(int j=0;j<c;j++)
			{
				arr[i][j] = s.charAt(j);
			}
		}
		
		dfs(0,0,1);
		
		System.out.println(maxcount);
	}
	
	public static void dfs(int x,int y,int count)
	{
		visited[x][y] =true;
		list.add(arr[x][y]);
		maxcount = Math.max(maxcount, count);
		
		for(int i=0;i<4;i++)
		{
			int kx = dx[i]+x;
			int ky = dy[i]+y;
			if(kx>=0&&ky>=0&&kx<r&&ky<c)
			{
				if(!list.contains(arr[kx][ky])&&!visited[kx][ky])
				{		
					dfs(kx,ky,count+1);
				}
			}
		}
		
		visited[x][y] =false;
		list.remove(list.size()-1);
	}
}