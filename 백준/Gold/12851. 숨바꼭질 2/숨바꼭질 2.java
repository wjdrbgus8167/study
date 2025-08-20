import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        int[] dist = new int[MAX + 1];
        int[] ways = new int[MAX + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(N);
        dist[N] = 0;
        ways[N] = 1;

        while (!q.isEmpty()) {

            int cur = q.poll();

            int[] nexts = {cur - 1, cur + 1, cur * 2};

            for (int nx : nexts) {

                if (nx < 0 || nx > MAX) continue;


                if (dist[nx] == -1) {
                    dist[nx] = dist[cur] + 1;
                    ways[nx] = ways[cur];
                    q.add(nx);
                }

                else if (dist[nx] == dist[cur] + 1) {
                    ways[nx] += ways[cur];
                }
            }
        }

        System.out.println(dist[K]);
        System.out.println(ways[K]);
    }
}
