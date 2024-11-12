

import java.io.*;
import java.util.*;

public class Main {

	static int V,E;
	static int parents[];
	static class Edge {
		int from,to,cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents  = new int[V+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost, b.cost));
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Edge(from,to,cost));
			
			
		}
		make();
		int answer = 0;
		
		while(!pq.isEmpty()) {
			
			Edge e = pq.poll();
			
			if(union(e.from,e.to)) {
				
				answer += e.cost;
			}
		}
		
		System.out.println(answer);
		
	}
	public static void make() {
		for(int i=0;i<V+1;i++) {
			
			parents[i] = i;
		}
		
	}
	
	public static int find(int a) {
		if(parents[a]==a) return a;
		
		return parents[a] = find(parents[a]);
	}
	public static boolean union(int a,int b) {
		
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot ==bRoot) return false;
		
		parents[aRoot] = bRoot;
		
		return true;
	}
	
	

}
