

import java.io.*;
import java.util.*;

class Point3{
	
	int x;
	int y ;
	
	public Point3() {
		
		super();
	}
	public Point3(int x,int y) {
		
		this.x= x;
		this.y = y;
		
		
	}
	@Override
	public String toString() {
		return "Point3 [x=" + x + ", y=" + y + "]";
	}
	
	
}
public class Main {

	static int N;
	static int map[][];
	static int babyshark =2;
	static int eatingfish= 0;
	static int time =0;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	static boolean visited[][];
	public static void main(String[] args )throws IOException {
		
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		map  =new int [N][N];
		
		StringTokenizer st ;
		
		int start_Idx=0;
		int start_Idy = 0;
		
		for(int i=0;i<N;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					start_Idx = i;
					start_Idy = j;
					
				}
			}
		}
		
		map[start_Idx][start_Idy] = 0;
		bfs(start_Idx,start_Idy);
		
		System.out.println(time);
		
	}
	public static void bfs(int x,int y) {
		
		while(true) {
			
			
			Queue<Point3> que = new LinkedList<>();
			
			visited = new boolean[N][N];
			que.add(new Point3(x,y));
			
			visited[x][y] = true;
			
			Point3 fish= null;
			
			// 거리 저장 배열 
			int [][] distance = new int[N][N];
			
			//생선을 못찾았을 시 
			boolean found = false;
			
			while(!que.isEmpty()) {
				
				Point3 cur =  que.poll();
				
				for(int i=0;i<4;i++) {
					
					int nx = cur.x+dx[i];
					int ny  = cur.y+dy[i];
					
					//만약 상어의 크기보다 작고 방문하지 않고 범위에 벗어나지 않았을 떄 
					
					if(boundcheck(nx,ny)&& !visited[nx][ny]&&map[nx][ny]<=babyshark) {
						
						visited[nx][ny] = true;
						
						que.add(new Point3(nx,ny));
						distance[nx][ny] = distance[cur.x][cur.y]+1;

						
						if(map[nx][ny]>0&&map[nx][ny]<babyshark) {
							
							if(fish ==null || distance[nx][ny]<distance[fish.x][fish.y]
									
							||(distance[nx][ny] == distance[fish.x][fish.y] && (nx < fish.x || (nx == fish.x && ny < fish.y)))) {
								
								fish = new Point3(nx,ny);
								found = true;
								
							}
						}
					}
					
					
				}
			}
			
			if(!found) {
				break;
			}
			
			time += distance[fish.x][fish.y];
			map[fish.x][fish.y]= 0;
			
			x= fish.x;
			y = fish.y;
			eatingfish++;
			
			if(babyshark == eatingfish) {
				babyshark++;
				eatingfish=0;
			}
			
		}
		
		
		
		
	}
	
	public static boolean boundcheck(int x,int y) {
		
		return x>=0&&y>=0&&x<N&&y<N;
	}
}
