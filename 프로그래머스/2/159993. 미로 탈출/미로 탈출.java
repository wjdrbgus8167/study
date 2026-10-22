import java.util.*;

class Solution {

    public int solution(String[] maps) {

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int n = maps.length;
        int m = maps[0].length();

        char[][] map = new char[n][m];
        boolean[][][] visited = new boolean[2][n][m];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                map[i][j] = maps[i].charAt(j);

                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[]{startX, startY, 0, 0});
        visited[0][startX][startY] = true;

        while (!que.isEmpty()) {

            int[] d = que.poll();

            int x = d[0];
            int y = d[1];
            int depth = d[2];
            int lever = d[3];

            if (map[x][y] == 'L') {
                lever = 1;
            }

            if (map[x][y] == 'E' && lever == 1) {
                return depth;
            }

            for (int j = 0; j < 4; j++) {

                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx < 0 || nx >= n ||ny < 0 || ny >= m) continue;
            

                if (map[nx][ny] == 'X') continue;

                int nextLever = lever;

                if (map[nx][ny] == 'L') nextLever = 1;
                

                if (visited[nextLever][nx][ny]) continue;
                

                visited[nextLever][nx][ny] = true;

                que.offer(new int[]{nx, ny, depth + 1, nextLever});
            }
        }

        return -1;
    }
}