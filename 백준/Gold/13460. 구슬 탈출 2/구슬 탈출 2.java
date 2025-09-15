import java.io.*;
import java.util.*;

class State {
    int rx, ry, bx, by, depth;

    public State(int rx, int ry, int bx, int by, int depth) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.depth = depth;
    }
}

class MoveResult {
    int x, y, moved;
    boolean inHole;

    MoveResult(int x, int y, int moved, boolean inHole) {
        this.x = x;
        this.y = y;
        this.moved = moved;
        this.inHole = inHole;
    }
}

public class Main {

    static int N, M;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {

            String s = br.readLine();

            for (int j = 0; j < M; j++) {

                char c = s.charAt(j);
                board[i][j] = c;

                if (c == 'R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.';
                }
                else if (c == 'B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {

        boolean[][][][] visited = new boolean[N][M][N][M];
        Queue<State> q = new ArrayDeque<>();
        visited[rx][ry][bx][by] = true;
        q.add(new State(rx, ry, bx, by, 0));

        while (!q.isEmpty()) {

            State cur = q.poll();
            if (cur.depth >= 10) continue;

            for (int dir = 0; dir < 4; dir++) {

                MoveResult r = roll(cur.rx, cur.ry, dir);
                MoveResult b = roll(cur.bx, cur.by, dir);

                if (b.inHole) continue;

                if (r.inHole) return cur.depth + 1;

                int nrx = r.x, nry = r.y;
                int nbx = b.x, nby = b.y;

                if (nrx == nbx && nry == nby) {

                    if (r.moved > b.moved) {
                        nrx -= dx[dir];
                        nry -= dy[dir];
                    } else {
                        nbx -= dx[dir];
                        nby -= dy[dir];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new State(nrx, nry, nbx, nby, cur.depth + 1));
                }
            }
        }
        return -1;
    }

    static MoveResult roll(int x, int y, int dir) {

        int cx = x, cy = y, moved = 0;

        while (true) {

            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            char next = board[nx][ny];

            if (next == '#') break;

            cx = nx;
            cy = ny;
            moved++;

            if (next == 'O') {
                return new MoveResult(cx, cy, moved, true);
            }
        }
        return new MoveResult(cx, cy, moved, false);
    }
}
