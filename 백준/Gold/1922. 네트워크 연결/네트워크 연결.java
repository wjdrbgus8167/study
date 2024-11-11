

import java.io.*;
import java.util.*;
public class Main {
	static class Edge implements Comparable<Edge>{
		int from,to, cost;

		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost- o.cost;
		}
		
		
	}
	static int parents[];
	static int N,M,result;
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		make();
		result=0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to =  Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			pq.offer(new Edge(from,to,cost));
			
		}
		
		while(!pq.isEmpty()) {
			
			Edge cur = pq.poll();
			
			if(union(cur.from,cur.to)) {
				
				result +=cur.cost;
			}
		}
		
		System.out.println(result);
	}
	
	static void make() {
		parents = new int[N+1];
		
		for(int i=0;i<N+1;i++) {
			parents[i] =i;
			
		}
		
	}
	static int find(int a) {
		
		if(parents[a]==a) {
			return a;
		}
		
		
		return parents[a]=find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) {
			return false;
		}
		
		parents[aRoot] = bRoot;
		
		return true;
	}

	
}
