
import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int map[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cnt=1;
		
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			if(N==0)
				break;
			
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("Problem "+cnt+":"+" "+thiefRupee(0,0,N-1,N-1)).append("\n");
			cnt++;
		}
		System.out.println(sb);
		
	}
	public static int thiefRupee(int sr,int sc,int er,int ec) {
		
		int INF = Integer.MAX_VALUE;
		boolean visited[][] = new boolean[N][N];
		int minSteal[][] = new int[N][N];
		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<N;j++) {
				minSteal[i][j] =INF;
			}
		}
		
		PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->Integer.compare(a[2], b[2]));
		minSteal[sr][sc] = map[0][0];
		
		que.add(new int[]{sr,sc,minSteal[sr][sc]});
		
		while(!que.isEmpty()) {
			int stopOver[] = que.poll();
			
			int r = stopOver[0];
			int c = stopOver[1];
			int weight = stopOver[2];
			
			if(visited[r][c]) continue;
			
			visited[r][c] = true;
			if(r==er&& c==ec) return weight; // return minTime[er][ec];도 가능 
			
			for(int i=0;i<4;i++) {
				int nr = dx[i]+r;
				int nc= dy[i]+c;
				
				if(boundChecking(nr,nc)&&!visited[nr][nc]&&minSteal[nr][nc]>weight+map[nr][nc]) {
					minSteal[nr][nc] = weight+map[nr][nc];
					que.offer(new int[] {nr,nc,minSteal[nr][nc]});
				}
			}
		}
		
		return -1;
	}
	public static boolean boundChecking(int x,int y) {
		
		return x>=0&&x<N&&y>=0&&y<N;
	}

}
