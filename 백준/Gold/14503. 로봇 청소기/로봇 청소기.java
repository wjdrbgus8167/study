

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서 방향
    static int[] dy = {0, 1, 0, -1};
    static int sr, sc;
    static int direction;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = clean(sr, sc, direction);
        System.out.println(result);
    }

    public static int clean(int x, int y, int d) {
        int cleanedCount = 0;

        while (true) {
            // 1. 현재 칸을 청소
            if (!visited[x][y]) {
                visited[x][y] = true;
                cleanedCount++;
            }

            boolean foundUncleaned = false;

            // 2. 주변 4칸을 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향 회전
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 청소되지 않은 빈 칸이 있는 경우
                if (inBounds(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny]) {
                    x = nx;
                    y = ny;
                    foundUncleaned = true;
                    break;
                }
            }

            // 3. 청소되지 않은 빈 칸이 없는 경우
            if (!foundUncleaned) {
                int backX = x - dx[d];
                int backY = y - dy[d];

                // 후진 가능 여부 확인
                if (inBounds(backX, backY) && map[backX][backY] == 0) {
                    x = backX;
                    y = backY;
                } else {
                    break; // 후진도 불가능한 경우 종료
                }
            }
        }

        return cleanedCount;
    }

    public static boolean inBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
