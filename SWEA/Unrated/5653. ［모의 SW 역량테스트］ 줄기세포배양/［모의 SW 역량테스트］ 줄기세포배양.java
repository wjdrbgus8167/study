



import java.util.*;
import java.io.*;


public class Solution {

	static int map[][];
	static int t,N,M,K;
	
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	static int DEAD=0, ACTIVE =1, INACTIVE=2;
	
	static boolean visited[][];
	static List<stemcell> cell;
	static PriorityQueue<stemcell> pq;
	
	static class stemcell{
		int x,y;
		int time,state,power;
		
		stemcell(int x,int y, int time, int power){
			this.x=x;
			this.y =y;
			this.time = time;
			this.state =INACTIVE;
			this.power = power;
		}
		
	}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		
		// 초기 상태에서 줄기 세포들은 비활성 상태. 생명력 수치가 X인 줄기 세포의 경우 X 비활성 상태이고 
		// X 시간이 지나는 순간 활성 상태. 활성 상태가 되면 X 시간 동안 살아있을 수 있으며 X시간이 지나면 세포는 죽음
		// 죽은 상태로 셀 차지 
		// 활성화된 줄기 세포는 첫 1시간 동안 상,하,좌,우 네 방향으로 동시에 번식한다. 
		// 번식된 줄기 세포는 비활성 상태 
		// 두 개 이상의 줄기 세포가 하나의 그리드 셀에 동시 번식하려고 하는 경우 생명령 수치가 높은 줄기 세포가 
		// 해당 셀을 차지 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
	
		t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc=1;tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			
			N= Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			// 배양 시간 
			K = Integer.parseInt(st.nextToken());
			
			
			cell =  new ArrayList<>();
			pq = new PriorityQueue<>((a,b)->b.power-a.power);
			visited = new boolean[N+2*K][M+2*K];
			
			// N+2*k, M+2*k ->시간은 K초 -> 이는 즉 K초만큼 늘어나기 때문에 상화좌우로 k씩 늘어난다고 보면 됨.
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					int n  =Integer.parseInt(st.nextToken());
					
					if(n!=0) {
						// 초기 cell 값 입력 
						cell.add(new stemcell(i+K,j+K,n,n));
						visited[i+K][j+K]=true;
					}
				}
			}
			
			bfs();
			sb.append("#"+tc+" "+count()).append("\n");
			
			
			
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		for(int k=1;k<=K;k++) {
			
			// 직전에 INACTIVE -> ACTIVE 상태로 변경 
			while(!pq.isEmpty()) {
				stemcell c = pq.poll();
				int x = c.x;
				int y = c.y;
				
				if(!visited[x][y]) {
					visited[x][y]= true;
					cell.add(c);
				}
			}
			
			for(int i=0;i<cell.size();i++) {
				if(cell.get(i).state==DEAD) {
					continue;
				}else if(cell.get(i).state==INACTIVE && cell.get(i).time==k){
					cell.get(i).state =ACTIVE;  // X 시간동안 활성상태
					cell.get(i).time = k+cell.get(i).power;// 현재 시간보다 X 시간이 지난 상태
					// 생명 주기를 시간에 맞춰 빼는게 아니라 더해주면서 확인하기 
					for(int d=0;d<4;d++) {
						// k+1+power 후에 변경상태가 될 것 
						int nx = cell.get(i).x+dx[d];
						int ny = cell.get(i).y+dy[d];
						
						pq.add(new stemcell(nx,ny,k+1+cell.get(i).power,cell.get(i).power));
					}
				}else if(cell.get(i).state==ACTIVE && cell.get(i).time==k){
					cell.get(i).state = DEAD;
					cell.get(i).time =0;
					cell.get(i).power = 0;
				}
				
			}
			
		}
	}
	static int count() {
		int cnt=0;
		for(int i=0;i<cell.size();i++) {
			if(cell.get(i).state==ACTIVE||cell.get(i).state==INACTIVE) {
				cnt++;
			}
		}
		return cnt;
	}
	
}


