import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static int map[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		// 미로는 N*M 크기, 미로는 빈방 or 벽, 벽은 부수지 않으면 이동할 수 없다.
		// 알고스팟 운영진은 여러명. 항상 모두 같은 방에 있어야함. 여러 명이 다른 방에 있을 수는 없다. 
		//  어떤 방에서 이동할 수 있는 방은 상하좌우로 인접한 빈 방이다. 
		// 벽은 평소에 이동 x, 단, 알고스팟의 무기 AOJ를 이용해 벽을 부술 수 있다. 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		for(int i=0;i<M;i++) {
			
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = s.charAt(j)-48;
			}
		}
		
		int breakwall = bfs(0,0,M-1,N-1);
	
		System.out.println(breakwall);
	}
	
	public static int bfs(int sn,int sm,int en,int em) {
		
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
		
		boolean visited[][] = new boolean[M][N];
		
		visited[sn][sm] =true;
		que.add(new int[] {sn,sm,0});
		
		while(!que.isEmpty()) {
			
			int cur[] = que.poll();
			
			int cur_x = cur[0];
			int cur_y = cur[1];
			int wall = cur[2];
			
			if(cur_x==en&&cur_y==em) {
				
				return wall;
			}
			
			for(int i=0;i<4;i++) {
				
				int nx = dx[i]+cur_x;
				int ny = dy[i]+cur_y;
			
				if(boundchecking(nx,ny)&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					
					if(map[nx][ny]==0) {
						
						que.add(new int[] {nx,ny,wall});
					}else {
						
						que.add(new int[] {nx,ny,wall+1});
					}
				}
				
			}
			
		}
		
		return -1;
	}
	
	public static boolean boundchecking(int x,int y) {
		
		return x>=0&&y>=0&&x<M&&y<N;
	}

}
