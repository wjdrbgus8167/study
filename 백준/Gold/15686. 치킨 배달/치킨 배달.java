
import java.io.*;
import java.util.*;

class Node{
	int x;
	int y;
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class Main {

	static int N,M;
	static Node arr[];
	
	static int map[][];
	static int min_distance;
	static int chicken[];
	static int chickencnt;
	static ArrayList<Node> home;
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		// 치킨집 개수 
		chickencnt =0;
		// 전체 배열 
		map = new int[N][N];
		
		arr = new Node[13];
		// 조합으로 뽑아낸 치킨집 
		chicken = new int[M];
		// 집 좌표 저장 
		home = new ArrayList<>();
		
		// 최소 거리 
		min_distance =Integer.MAX_VALUE;
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					arr[chickencnt] = new Node(i,j);
					chickencnt++;
				}else if(map[i][j]==1) {
					home.add(new Node(i,j));
					
				}
			}
		}
		
		calculate_distance(0,0);	
			
		
		
		System.out.println(min_distance);
		
	}
	
	public static void calculate_distance(int cnt,int idx) {
		
		if(cnt==M) {
			
			int sum=0;
			
			for(int i=0;i<home.size();i++) {
				int min =Integer.MAX_VALUE;
				for(int j=0;j<M;j++) {
					int distance = Math.abs(home.get(i).x-arr[chicken[j]].x)+Math.abs(home.get(i).y-arr[chicken[j]].y);

					min = Math.min(min, distance);
				}
				sum +=min;
			}
			
			min_distance = Math.min(min_distance, sum);
			
			return ;
		}
		
		for(int i=idx;i<chickencnt;i++) {
				chicken[cnt]=i;
				calculate_distance(cnt+1,i+1);
				
		}
	}

}

