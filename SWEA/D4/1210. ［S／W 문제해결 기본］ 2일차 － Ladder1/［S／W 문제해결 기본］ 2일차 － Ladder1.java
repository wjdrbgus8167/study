

import java.io.*;
import java.util.*;


public class Solution{

	static int ladder[][];
	static int dx[] = {1,0,0};
	static int dy[] = {0,1,-1};
	static int v1,v2;
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		for(int testcase= 1;testcase<=10;testcase++)
		{
			int T = Integer.parseInt(br.readLine());
			
			ladder = new int[100][100];
			// 입력 값 and v1,v2 -> 목적지 좌표
			for(int i=0;i<100;i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++)
				{
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j]==2)
					{
						v1=i;
						v2=j;
					}
				}
			}
			
			// 1행 탐색
			for(int i=0;i<100;i++)
			{
				if(ladder[0][i]==1)
				{
					
					if(v2==check(0,i,0))
					{
						sb.append("#"+T+" "+i).append("\n");
						
					}
				}
					
			}
			
			
		}
		System.out.println(sb);
		
	}
	public static int check(int x,int y,int direction)
	{
		// 끝에 도달하면 return 
		if(x==99)
		{
				
			return y;		
		}
		// 아래 방향일 때 조건
		if(direction==0)
		{
			// 좌우 탐색
			for(int i=1;i<=2;i++)
			{
				int lr_x = dx[i]+x;
				int lr_y = dy[i]+y;
				if(boundcheck(lr_x, lr_y)&&ladder[lr_x][lr_y]==1)
				{
					
					return check(lr_x,lr_y,i);
					
				}
			}
			// 좌우 불가능이면 다시 아래로 
			int down_x = dx[0]+x;
			int down_y = dy[0]+y;
			
			if(boundcheck(down_x,down_y)&&ladder[down_x][down_y]==1)
			{
				return check(down_x,down_y,0);
			}
			
		}else {
			// 옆으로 갈때 조건 
			int lr_x =dx[direction]+x;
			int lr_y =dy[direction]+y;
			if(boundcheck(lr_x, lr_y)&&ladder[lr_x][lr_y]==1)
			{
				 return check(lr_x,lr_y,direction);
			}else {
				int down_x = dx[0]+x;
				int down_y = dy[0]+y;
				
				if(boundcheck(down_x,down_y)&&ladder[down_x][down_y]==1)
				{
					return check(down_x,down_y,0);
				}
			}
			
			
		}
		
		return y;
		
	}
	public static boolean boundcheck(int x, int y)
	{
		if(x>=0&&x<100&&y>=0&&y<100)
		{
			return true;
		}
		
		return false;
	}
	
		
}
