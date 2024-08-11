
import java.io.*;
import java.util.*;



public class Solution {

	static int map[][];
	static boolean visited[][];
	static int N,M,L;
	
	static int count;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static int[][] pipe=
		{
				{},{0,1,2,3},{0,1},{2,3},{0,3},{1,3},
				{1,2},{0,2}
				
		};
	public static void main(String[] args)throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t= Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testcase=1;testcase<=t;testcase++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			count =0;
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++)
				{
					map[i][j] =Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(R,C);
			
			sb.append("#"+testcase+" "+count+"\n");
		}
		
		System.out.println(sb);
	
	}
	public static void bfs(int x, int y) {
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y,1});
		
		visited[x][y] =true;
		count++;
		while(!que.isEmpty())
		{
			int[] arr =que.poll();
			int depth= arr[2];
			if(depth>=L)
			{
				continue;
			}
		;
			for(int move : pipe[map[arr[0]][arr[1]]])
			{
				int k1= dx[move]+arr[0];
				int k2 = dy[move]+arr[1];
				
				if(k1>=0&&k1<N&&k2<M&&k2>=0&&!visited[k1][k2]&&map[k1][k2]!=0)
				{
					if(check(move,map[k1][k2]))
					{
						que.add(new int[] {k1,k2,depth+1});
						visited[k1][k2]=true;
						count++;
					}
				}
			}
		}
		
		
	}
	public static boolean check(int a,int mapcheck)
	{
		if(a==0)
		{
			if(mapcheck==1||mapcheck==2||mapcheck==5||mapcheck==6)
			{
				return true;
			}
		}else if(a==1)
		{
			if(mapcheck==1||mapcheck==2||mapcheck==4||mapcheck==7)
			{
				return true;
			}
		}else if(a==2)
		{
			if(mapcheck==1||mapcheck==3||mapcheck==4||mapcheck==5)
			{
				return true;
			}
		}else if(a==3)
		{
			if(mapcheck==1||mapcheck==3||mapcheck==6||mapcheck==7)
			{
				return true;
			}
		}
		return false;
	}
	
}