

import java.io.*;
import java.util.*;

class Point1{
	int x,y;
	
	public Point1(int x,int y) {
		
		this.x =x;
		this.y =y;
	}

	@Override
	public String toString() {
		return "Point1 [x=" + x + ", y=" + y + "]";
	}
	
	
}
public class Main {
	
	static int R,C;
	static char map[][];
	static boolean visited[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static Queue<Point1> water;
	static int homeIdx;
	static int homeIdy;
	static int distance[][];
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		// . : 비어있는 곳, *: 물, 돌 :x, D : 비버 굴, S:고슴도치 위치
		// 매분마다 상하좌우로 이동 가능, 물도 매분마다 비어있는 칸으로 확장 
		// 물이 있는 칸과 인접해있는 비어있는 칸(적어도 한변을 공유)이 물이 참 
		// 단, 물은 비버의 소굴로 이동 불가 
		// 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하시오 
		// 고슴도치는 물이 찰 예정인 칸으로 이동 불가.. 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C =  Integer.parseInt(st.nextToken());
		
		map  =new char[R][C];
		distance  =new int[R][C];
		
		water = new LinkedList<>();
		int start_x=0;
		int start_y=0;
		
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++){
				
				
				map[i][j]= s.charAt(j);	
				
				if(map[i][j]=='S') {
					start_x=i;
					start_y=j;
				}else if(map[i][j]=='*'){
					water.add(new Point1(i,j));
				}else if(map[i][j]=='D') {
					homeIdx = i;
					homeIdy = j;
				}
			}
		}
		
		
		int mintime = escape(start_x,start_y);
		if(mintime !=-1) {
			System.out.println(mintime);
		}else {
			System.out.println("KAKTUS");
		}
		
	}
	public static int escape(int x,int y ) {
		
		Queue<Point1> que = new LinkedList<>();
		visited = new boolean[R][C];
		
		Point1 p = new Point1(x,y);
		que.add(p);
		visited[x][y] = true;
		distance[x][y] = 0;
		
		while(!que.isEmpty()) {
			
			int temp= que.size();
				
			int size = water.size();
			
			for(int i=0;i<size;i++) {
				Point1 p2 =  water.poll();
				waterspread(p2.x,p2.y);
			
			}
			
			for(int k=0;k<temp;k++) {
				
				Point1 p1 =que.poll();
			
			
				if(p1.x==homeIdx&&p1.y==homeIdy) {
						
					return distance[p1.x][p1.y];
				}
					
					for(int i=0;i<4;i++) {
						
						int nx = p1.x+dx[i];
						int ny = p1.y+dy[i];
						
						if(boundcheck(nx, ny)&&!visited[nx][ny]) {
							if(map[nx][ny]=='.') {
								distance[nx][ny] =distance[p1.x][p1.y]+1;
								visited[nx][ny] = true;
								map[nx][ny]='S';
								que.add(new Point1(nx,ny));
							}else if(map[nx][ny]=='D') {
								distance[nx][ny] =distance[p1.x][p1.y]+1;
								visited[nx][ny] = true;
								
								que.add(new Point1(nx,ny));
							}
							
						}
								
					}	
				
				
			}
	
					
		}
		return -1;
		
	}
	public static void waterspread(int x,int y) {
	
		
		for(int i=0;i<4;i++) {
			
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(boundcheck(nx,ny)) {
				if(map[nx][ny]=='.') {
					
					map[nx][ny] = '*';
					water.add(new Point1(nx,ny));
				}
			}
			
		}
		
		return ;
	}
	
	public static boolean boundcheck(int x,int y) {
		return x>=0&&y>=0&&x<R&&y<C;
	}

}
