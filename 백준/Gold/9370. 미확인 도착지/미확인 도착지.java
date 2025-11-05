import java.io.*;
import java.util.*;


class Main {

    static int n, m, t;
    static int s, g, h;

    static ArrayList<int[]> graph[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < tc; i++) {

            st = new StringTokenizer(br.readLine());

            // 교차로(노드 개수)
            n = Integer.parseInt(st.nextToken());
            //도로
            m = Integer.parseInt(st.nextToken());
            // 목적지 후보개수
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            // 현재 예술가의 위치
            s = Integer.parseInt(st.nextToken());

            // 지나간 교차로(지나갈 노드)
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];

            for (int j = 1; j <= n; j++) graph[j] = new ArrayList<>();


            for (int j = 0; j < m; j++) {

                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken())<<1;

                if((a==g&&b==h)||(a==h&&b==g)) d--;

                graph[a].add(new int[]{b, d});
                graph[b].add(new int[]{a, d});

            }

            List<Integer> result = new ArrayList<>();

            for(int j=0;j<t;j++){

                int sub = Integer.parseInt(br.readLine());
                int cost = djk(s,sub);

                if(cost%2==1) result.add(sub);
            }

            Collections.sort(result);

            for(int a: result) sb.append(a+" ");

            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int djk(int start, int end){

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        int[] dist = new int[n+1];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        pq.add(new int[]{start,0});

        while(!pq.isEmpty()){

            int[] cur = pq.poll();

            int cur_point = cur[0];
            int cur_cost = cur[1];

            if(cur_point==end ) return cur_cost ;

            if(dist[cur_point]<cur_cost) continue;

            for(int[] a: graph[cur_point]){

                int next_point = a[0];
                int next_cost = a[1]+cur_cost;

                if(dist[next_point]>next_cost){

                    dist[next_point] = next_cost;

                    pq.add(new int[]{next_point,next_cost});
                }
            }

        }

        return -1;
    }
}