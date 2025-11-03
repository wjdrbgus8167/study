import java.io.*;
import java.util.*;

class Main{

    static int N,E;
    static List<int[]>[] Edge;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 인접 리스트 배열
        Edge = new ArrayList[N+1];

        for (int i=1; i<=N;i++) Edge[i] = new ArrayList<>();

        for(int i=0;i<E;i++){

            st=  new StringTokenizer(br.readLine());;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

           Edge[a].add(new int[]{b,d});
           Edge[b].add(new int[]{a,d});

        }

        st= new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1부터 시작해서 모든 노드 N까지 가는 최단 거리
        int[] dist1 = djk(1);
        // v1부터 시작해서 모든 노드 N까지 가는 최단 거리
        int[] dist2 = djk(v1);
        // v2부터 시작해서 모든 노드 N까지 가는 최단 거리
        int[] dist3 = djk(v2);

        // 1->v1->v2->N까지 가는 경우
        long path1 = (long) dist1[v1]+dist2[v2] + dist3[N];

        // 1->v2->v1->N까지 가는 경우
        long path2 = (long) dist1[v2]+dist3[v1] + dist2[N];

        long answer = Math.min(path1, path2);

        if (answer >= INF){
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }

    public static int[] djk(int start) {

        int[] dist = new int[N + 1];
        Arrays.fill(dist,INF);
        dist[start] =0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{start,0});

        while(!pq.isEmpty()){

            int[] now = pq.poll();
            int cur = now[0];
            int cost = now[1];

            if(dist[cur]<cost) continue;

            for(int[] next: Edge[cur]){
                int nx = next[0];
                int next_cost = cost+next[1];

                if(next_cost<dist[nx]){
                    dist[nx] = next_cost;
                    pq.add(new int[]{nx,next_cost});
                }
            }
        }

        return dist;
    }

}