


import java.io.*;
import java.util.*;

class Point5 {
    int x;
    int weight;

    public Point5(int x, int weight) {
        this.x = x;
        this.weight = weight;
    }
}

public class Main{

    static int V, E;
    static ArrayList<Point5>[] map;
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        map = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
        }

        // 거리 최대 값으로 모두 갱신 
        distance = new int[V + 1];
        Arrays.fill(distance, INF);

        // 각 노드와 노드 간선들의 가중치 저장 
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[startNode].add(new Point5(endNode, weight));
        }

        dijkstra(start);
        
        // 출발 지점에서 부터 모든 노드에 대해 방문했을 때 최소 거리
        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    public static void dijkstra(int start) {
      
    	PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->Integer.compare(a[1], b[1]));
        queue.offer(new int[]{start, 0});
        distance[start] = 0;

        while (!queue.isEmpty()) {
            
        	int[] current = queue.poll();
            // 현재 노드 번호 
            int currentNode = current[0];
            // 현재 노드의 가중치 
            int currentDist = current[1];
            // 만약 현재 가중치가 더 크면 
            if (currentDist > distance[currentNode]) {
                continue;
            }
            // 현재 노드에서 이동 가능한 이웃 노드들 탐색 
            for (Point5 p : map[currentNode]) {
                // 현재 노드에서 다음 노드의 가중치를 더한 값.
            	int newDist = currentDist + p.weight;
                // 만약 새로운 노드로 가는 가충치의 값이 기존에 값보다 작다면 값 갱신 
            	if (newDist < distance[p.x]) {
                    distance[p.x] = newDist;
                    queue.offer(new int[]{p.x, newDist});
                }
            }
        }
    }
}
