

import java.io.*;
import java.util.*;


// k에 따라 운영 비용이 커진다. 
// 단, 범위가 배열 밖을 벗어나도 똑같은 비용이 청구된다. 
// 집들의 수익보다 운영비용보다 작아지면 return., 
public class Solution {

	static class Node{
		
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	static int N,M;
	static int map[][];
	static boolean visited[][];
	
	static int maxHomeCnt;
	static int dx[] = {1,0,-1,0};
	static int dy[]= {0,1,0,-1};
	
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb =new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
		
			
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}

			maxHomeCnt =0;
			
			for(int i=0;i<N;i++) {
				
				for(int j=0;j<N;j++) {
					
					visited = new boolean[N][N];
					homeProtectService(i, j);
				
				}
			}
			
			sb.append("#"+tc+" "+maxHomeCnt+"\n");
			
		}
		System.out.println(sb);
	}
	public static void homeProtectService(int x,int y) {
		ArrayDeque<Node> que = new ArrayDeque<>();
        que.add(new Node(x, y));
        visited[x][y] = true;
        int k = 1;
        int cnt = map[x][y] == 1 ? 1 : 0;
        int pay = k * k + (k - 1) * (k - 1);
        int profit = cnt * M;
        
        if (profit >= pay) {
            maxHomeCnt = Math.max(maxHomeCnt, cnt);
        }
		
		while(!que.isEmpty()) {
			
			k++;
			
			int size = que.size();
			
			for(int j=0;j<size;j++) {
				Node index = que.poll();
				
				for(int i=0;i<4;i++) {
					int nx = dx[i] + index.x;
					int ny = dy[i] + index.y;
					
					if(boundChecking(nx, ny)) {
						if(!visited[nx][ny]) {
							visited[nx][ny]=true;
							que.add(new Node(nx,ny));
							if(map[nx][ny]==1) {
								cnt++;
							}
						}
						
						
					}
					
				}
			}
			
			
			profit = cnt*M;
			pay = k*k+(k-1)*(k-1);
			
			if(profit>=pay){
				
				maxHomeCnt =Math.max(maxHomeCnt, cnt);
			}
			
		}
		
		
	}

	public static boolean boundChecking(int x,int y) {
		
		return x>=0&&x<N&&y>=0&&y<N;
	}
}
