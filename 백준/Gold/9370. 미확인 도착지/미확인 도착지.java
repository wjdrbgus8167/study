import java.io.*;
import java.util.*;


class Main{

    static int n,m,t;
    static int s,g,h;

    static ArrayList<int[]> graph[];

    public static void main(String[] args)throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0;i<tc;i++){

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

            graph= new ArrayList[n+1];

            for(int j=1;j<=n;j++) graph[j] = new ArrayList<>();


            for(int j=0;j<m;j++){

                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new int[]{b,d});
                graph[b].add(new int[]{a,d});

            }

            PriorityQueue<Integer> result = new PriorityQueue<>((a,b)->Integer.compare(a,b));

            for(int j=0;j<t;j++){

                int sub_endPoint = Integer.parseInt(br.readLine());

                // s까지의 최단경로
                int[] distS = djk(s);
                // g까지의최단 경로
                int[] distG = djk(g);
                //h까지의 최단 경로
                int[] distH = djk(h);

                int o_cost = distS[sub_endPoint];

                int g_cost = distS[g] + distG[h] + distH[sub_endPoint];
                int h_cost = distS[h] + distH[g] + distG[sub_endPoint];


                if(g_cost==o_cost||h_cost==o_cost){
                    result.add(sub_endPoint);
                }

            }

            while (!result.isEmpty()) sb.append(result.poll()).append(' ');

            sb.append("\n");
        }

        System.out.println(sb);
    }


    // 교차로 노드까지의 최단 경로
    public static int[] djk(int start_point){

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        int[] dist = new int[n+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[start_point] = 0;

        pq.add(new int[]{start_point,0});


        while(!pq.isEmpty()){

            int[] cur = pq.poll();

            int cur_point = cur[0];
            int cur_cost = cur[1];


            if(dist[cur_point]<cur_cost) continue;

            for(int[] a : graph[cur_point]){

                int next_point = a[0];
                int next_cost = a[1]+cur_cost;

                if(dist[next_point]>next_cost){
                    dist[next_point] = next_cost;

                    pq.add(new int[]{next_point,next_cost});

                }

            }


        }

        return dist;

    }


}