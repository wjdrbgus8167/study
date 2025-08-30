import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] adj;
    static int[] parent, rankArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] plan = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N+1];
        rankArr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= N; j++) {
                if (adj[i][j] == 1) {
                    union(i, j);
                }
            }
        }


        int root = find(plan[0]);
        boolean ok = true;

        for (int i = 1; i < M; i++) {

            if (find(plan[i]) != root) {
                ok = false;
                break;
            }
        }

        System.out.println(ok ? "YES" : "NO");
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a), pb = find(b);

        if (pa == pb) return;

        if (rankArr[pa] < rankArr[pb]) {
            parent[pa] = pb;
        } else if (rankArr[pa] > rankArr[pb]) {
            parent[pb] = pa;
        }
        else {
            parent[pb] = pa; rankArr[pa]++;
        }
    }
}
