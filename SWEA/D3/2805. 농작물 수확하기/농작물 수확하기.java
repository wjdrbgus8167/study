

import java.io.*;
import java.util.*;


public class Solution {

	static int N;
	static int map[][];
	static int sum;
	static int dx[] = {1,-1,-1,1};
	static int dy[] = {1,1,-1,-1};
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				
				for(int j=0;j<N;j++) {
					map[i][j] = s.charAt(j)-48;
				}
			}
			
			sum =0;
			int x_num = N/2;
			sum += map[x_num][x_num];
			
			for(int i=0;i<N/2;i++) {
				
				mapping(x_num,i,0,i,N-i);	
			}
			sb.append("#"+tc+" "+sum+"\n");	
		}
		System.out.println(sb);
	}
	public static void mapping(int x,int y,int dir,int start_range,int end_range) {
		
		int origin_x=x;
		int origin_y =y;
		sum = sum+map[x][y];
		
		while(true)
		{
			
			int next_x = dx[dir]+x;
			int next_y = dy[dir]+y;
			
				
			if(next_x>=start_range&&next_x<end_range&&next_y>=start_range&&next_y<end_range) {
				
				if(next_x==origin_x&&next_y==origin_y) {
					
					break;
				}
			
				
				sum += map[next_x][next_y];
				
				x= next_x;
				y = next_y;	
				
				
			}else{
				
				dir = (dir+1)%4;
			}
			
		}
		return;	
		
	}

}
