import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x, y, k, step;
        boolean cp;

        Node(int x, int y, int k, int step, boolean cp) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.step = step;
            this.cp = cp;
        }
    }

    static int N, M, K;
    static int[][] map;

    // visited[x][y][k][cp]
    static boolean[][][][] visited;

    // 기본 상하좌우
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 패턴 이동 리스트
    static ArrayList<int[]> pattern = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 패턴 읽기
        for (int i = 0; i < 5; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {

                int v = Integer.parseInt(st.nextToken());

                if (v == 1) {
                    pattern.add(new int[]{i - 2, j - 2});
                }
            }
        }

        visited = new boolean[N][M][K + 1][2];

        System.out.println(bfs());
    }

    public static int bfs() {

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, K, 0, false));
        visited[0][0][K][0] = true;

        while (!q.isEmpty()) {

            Node cur = q.poll();

            // 중간 거점 방문했고 도착지 도달하면 끝
            if (cur.cp && cur.x==N-1 && cur.y == M-1) {
                return cur.step;
            }

            //int cpIndex = cur.cp ? 1 : 0;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!bound(nx, ny) && map[nx][ny] != 1) {

                    boolean nextCP = cur.cp || (map[nx][ny] == 2);
                    int nextCPIndex = nextCP ? 1 : 0;

                    if (!visited[nx][ny][cur.k][nextCPIndex]) {
                        visited[nx][ny][cur.k][nextCPIndex] = true;
                        q.add(new Node(nx, ny, cur.k, cur.step + 1, nextCP));
                    }
                }
            }

            if (cur.k > 0) {
                for (int[] p : pattern) {

                    int nx = cur.x + p[0];
                    int ny = cur.y + p[1];

                    if (!bound(nx, ny) && map[nx][ny] != 1) {

                        boolean nextCP = cur.cp || (map[nx][ny] == 2);
                        int nextCPIndex = nextCP ? 1 : 0;

                        if (!visited[nx][ny][cur.k - 1][nextCPIndex]) {
                            visited[nx][ny][cur.k - 1][nextCPIndex] = true;
                            q.add(new Node(nx, ny, cur.k - 1, cur.step + 1, nextCP));
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static boolean bound(int x, int y) {
        return x<0 || x>=N || y<0 || y>=M;
    }
}
