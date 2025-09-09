

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int map[][];
    static boolean visited[][];
    static ArrayDeque<int[]> que;
    static int exittime;
    static int dx[] = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int dy[] = {0, 1, 0, -1};
    static int direction;
    static int curx = 0;
    static int cury = 0;
    static boolean end;
    static ArrayDeque<int[]> commands; // 시간과 명령어 저장하는 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1; // 사과 위치
        }

        int L = Integer.parseInt(br.readLine());
        commands = new ArrayDeque<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String comm = st.nextToken();
            commands.add(new int[] {time, comm.equals("L") ? -1 : 1}); // L이면 -1, D면 +1
        }

        exittime = 0;
        direction = 1; // 처음 오른쪽(동쪽) 방향
        map[0][0] = 2;
        end = true;
        visited[0][0] = true;
        que = new ArrayDeque<>();
        que.add(new int[] {0, 0});

        // 방향 전환 없이 그냥 계속 움직이기
        move();

        System.out.println(exittime);
    }

    public static void move() {
        while (end) {
            // 먼저 방향을 전환할 시간이 됐는지 확인
            if (!commands.isEmpty() && commands.peek()[0] == exittime) {
                int[] command = commands.poll();
                direction = (direction + command[1] + 4) % 4; // 방향 변경 (L이면 -1, D면 +1)
            }

            int nx = dx[direction] + curx;
            int ny = dy[direction] + cury;

            // 종료 조건: 벽에 부딪히거나 자기 몸에 부딪힌 경우
            if (!boundcheck(nx, ny) || visited[nx][ny]) {
                end = false;
                exittime++; // 이 때도 시간 증가
                break;
            }

            if (map[nx][ny] == 1) { // 사과가 있는 경우
                map[nx][ny] = 0;
                visited[nx][ny] = true;
                que.add(new int[] {nx, ny});
            } else { // 사과가 없는 경우 꼬리를 이동시킴
                visited[nx][ny] = true;
                int[] tail = que.poll();
                visited[tail[0]][tail[1]] = false;
                que.add(new int[] {nx, ny});
            }

            // 머리 위치 업데이트
            curx = nx;
            cury = ny;
            exittime++;
        }
    }

    public static boolean boundcheck(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
