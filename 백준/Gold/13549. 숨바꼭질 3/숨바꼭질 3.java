import java.io.*;
import java.util.*;


class Main{

    static int N,K;
    static int min_day;
    static int Max =200000;
    static boolean[] visited;

    public static void main(String[] args)throws IOException{

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[Max+1];
        min_day = 0;

        if(N>=K){
            System.out.println(N-K);
        }else{
            bfs();
            System.out.println(min_day);
        }

    }

    public static void bfs() {

        int[] dist = new int[Max + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dist[N] = 0;
        dq.add(N);

        while (!dq.isEmpty()) {

            int x = dq.pollFirst();
            if (x == K) min_day=dist[x];

            int nx = x * 2;

            if (nx <= Max && dist[nx] > dist[x]) {
                dist[nx] = dist[x];
                dq.addFirst(nx);
            }

            nx = x - 1;

            if (nx >= 0 && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }

            nx = x + 1;

            if (nx <= Max && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }
        }
        return ;
    }
}