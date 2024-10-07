

import java.io.*;
import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int map[][];
    static ArrayList<Point> list;
    static boolean visited[][];
    static boolean combi[];
    static int copymap[][];
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }

        result = Integer.MIN_VALUE;
        combi = new boolean[list.size()];
        combination(0, 0);
        System.out.println(result);
    }

    public static void combination(int cnt, int start) {
        if (cnt == 3) { // Limiting to 3 barriers
            copymap = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copymap[i], 0, M);
            }

            for (int k = 0; k < combi.length; k++) {
                if (combi[k]) {
                    int x = list.get(k).x;
                    int y = list.get(k).y;
                    copymap[x][y] = 1;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copymap[i][j] == 2) {
                        spread(i, j);
                    }
                }
            }

            result = Math.max(result, calculateArea());
            return;
        }

        for (int i = start; i < list.size(); i++) {
            if (!combi[i]) {
                combi[i] = true;
                combination(cnt + 1, i + 1);
                combi[i] = false;
            }
        }
    }

    public static void spread(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextIdx = x + dx[i];
            int nextIdy = y + dy[i];

            if (isInBounds(nextIdx, nextIdy) && copymap[nextIdx][nextIdy] == 0) {
                copymap[nextIdx][nextIdy] = 2;
                spread(nextIdx, nextIdy);
            }
        }
    }

    public static int calculateArea() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copymap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
