import java.io.*;
import java.util.*;

class Node {
    int to, cost;
    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static int N, M;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());   
        M = Integer.parseInt(br.readLine());   

        graph = new ArrayList[N+1];
        for (int i=1;i<=N;i++) graph[i] = new ArrayList<>();

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            int cost  = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int city_start = Integer.parseInt(st.nextToken());
        int city_end   = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(city_start, city_end));
    }

    static int dijkstra(int start, int end) {
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.cost) continue; 

            for (Node next : graph[cur.to]) {
                int newDist = cur.cost + next.cost;
                if (newDist < dist[next.to]) {
                    dist[next.to] = newDist;
                    pq.add(new Node(next.to, newDist));
                }
            }
        }

        return dist[end];
    }
}
