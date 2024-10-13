

import java.util.*;
import java.io.*;

public class Solution {
	
	static int N;
	static int map[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};

	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				
				char[] ch = br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					map[i][j] = ch[j]-'0';
				}
			}
			// 0,0 -> 시작 좌표 
			// N-1,N-1 -> 끝 좌표 
			sb.append("#"+tc+" "+getMinTime(0,0,N-1,N-1)).append("\n");
		}
		System.out.println(sb);		
				
				
		
	}
	static int getMinTime(int sr,int sc,int er,int ec) {
		
	int INF = Integer.MAX_VALUE;
	
	boolean visited[][] = new boolean[N][N];
	
	int minTime[][] = new int[N][N];
	
	//a[2]가 작으면 음수, 같으면 0, 크면 양수를 반환. 만약 a[2]가 더 작으면 a가 더 높은 우선순위를 가지게 됨.
	PriorityQueue<int[]> pque =new PriorityQueue<>((a,b)->Integer.compare(a[2], b[2]));
	
	// 최소값 비교를 위해 minTime에 Integer.MAX_VALUE;
	for(int i=0;i<N;i++) {
		for(int j=0;j<N;j++) {
			minTime[i][j]= INF;
		}
	}
	
	// 출발지를 0으로 설정 
	minTime[sr][sc] = 0;
	// 좌표값, 가중치 값을 배열로 담아서 pq에 저장 
	pque.offer(new int[] {sr,sc,minTime[sr][sc]});
		
	// bfs 시작 
	while(!pque.isEmpty()) {
		
		int[] stopOver = pque.poll();
		
		int r =stopOver[0];
		int c =stopOver[1];
		// time -> 현재 위치에서의 시간
		int time = stopOver[2];
		
		// 만약 방문한 적이 있으면 continue
		if(visited[r][c]) continue;
		// 방문하지 않았다면 true 처리 
		visited[r][c] =true;
		// 만약 목적지에 도달했다면 최소 시간 return 
		if(r==er&&c==er) return time; // return minTime[er][ec]도 가능 
		
		for(int i=0;i<4;i++) {
			int nr = r+dx[i];
			int nc = c+dy[i];
			// 범위 및 방문 여부 확인 
			if(boundChecking(nr,nc)&&!visited[nr][nc]) {
				
				// 만약 최소 시간이 기존 시간과 현재를 더한 거 보다 작을 때 
				if(minTime[nr][nc]>time+map[nr][nc]) {
					minTime[nr][nc] =time+map[nr][nc];
					pque.offer(new int[] {nr,nc,minTime[nr][nc]});
				}
			}
		}
		
		
	}
		
	
		return -1;
	}
	
	public static boolean boundChecking(int x,int y) {
		
		return x>=0&&y>=0&&x<N&&y<N;
	}
}
