

import java.io.*;
import java.util.*;


class Point{
	
	int x,y,k;
	
	public Point(int k,int x,int y) {
		this.k = k;
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int M,N,H;
	static int tomato[][][];
	static int dx[] = {1,0,-1,0,0,0};
	static int dy[] = {0,1,0,-1,0,0};
	static int dz[] = {0,0,0,0,-1,1};
	static ArrayList<Point> list;
	static int min;
	static boolean visited[][][];
	static int cnt;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][N][M];
		list = new ArrayList<>();
		
		cnt=0;
		for(int k=0;k<H;k++) {
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					
					tomato[k][i][j] = Integer.parseInt(st.nextToken());
					if(tomato[k][i][j]==1) {
						list.add(new Point(k,i,j));
						
					}else if(tomato[k][i][j]==0) {
						cnt++;
					}
				}
			}
		}
		
		
		min=0;
		
		ripen();
		
		if(cnt!=0) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
	}
	public static void ripen() {
		Queue<Point> que = new LinkedList<>();
		
		visited = new boolean[H][N][M];
		
		for(Point p :list) {
			que.add(new Point(p.k,p.x,p.y));
			visited[p.k][p.x][p.y] = true;
		}
		
		
		while(!que.isEmpty()) {
			
			int size = que.size();
			
			if(cnt==0) {
				return;
			}
			
			min++;
			
			for(int i=0;i<size;i++) {

				Point p = que.poll();
				
				for(int j=0;j<6;j++) {
					int nk = dz[j]+p.k;
					int nx = dx[j]+p.x;
					int ny = dy[j]+p.y;
					if(boundchecking(nk,nx,ny)&&!visited[nk][nx][ny]) {
						if(tomato[nk][nx][ny]==0) {
							tomato[nk][nx][ny]=1;
							cnt--;
							visited[nk][nx][ny] = true;
							que.add(new Point(nk,nx,ny));
						}
							
					}
				}

			}
			
		}
		
	}
	public static boolean boundchecking(int k,int x,int y) {
		
		return x>=0&&y>=0&&x<N&&y<M&&k>=0&&k<H;
	}
}
