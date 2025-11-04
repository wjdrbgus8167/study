import java.io.*;
import java.util.*;


class Edge{
    int end,cost;

    public Edge(int end,int cost){
        this.cost = cost;
        this.end = end;

    }

}
class Main{

    static int N,M;
    static List<int[]>[] graph;
    static int[] prev;
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new int[]{end,cost});

        }

        st = new StringTokenizer(br.readLine());
        int start_city = Integer.parseInt(st.nextToken());
        int end_city = Integer.parseInt(st.nextToken());

        int result = djk(start_city,end_city);
        
        System.out.println(result);
        
        ArrayList<Integer> route = new ArrayList<>();
        
        for(int cur = end_city;cur!=-1;cur=prev[cur]){
            route.add(cur);
        }
        
        Collections.reverse(route);
        System.out.println(route.size());
        for(int a: route) System.out.print(a+" ");
        
        
    }

    public static int djk(int start_city,int end_city){

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));

        int[] dist = new int[N+1];
        prev = new int[N+1];

        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(prev,-1);
        dist[start_city] =0;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(start_city);
        pq.add(new Edge(start_city,0));

        while(!pq.isEmpty()){

            Edge e = pq.poll();

            int cur_city = e.end;
            
            int cur_cost = e.cost;


            if(cur_city == end_city) return cur_cost;

            if(dist[cur_city]<cur_cost) continue;


            for(int[] a: graph[cur_city]){

                int next_city = a[0];
                int next_cost = a[1];

                if(dist[next_city]>cur_cost+next_cost){

                    dist[next_city] = cur_cost+next_cost;
                    prev[next_city] = cur_city;

                    pq.add(new Edge(next_city,dist[next_city]));
                }
            }


        }

        return -1;
    }
}