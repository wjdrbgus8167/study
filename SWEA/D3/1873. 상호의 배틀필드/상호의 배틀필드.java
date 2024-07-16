

import java.io.*;
import java.util.*;

public class Solution {
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static char arr[][];
    public static int H, W;
    public static char directionstate;
    public static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int testcase = 1; testcase <= t; testcase++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            arr = new char[H][W];
            x = 0;
            y = 0;

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    arr[i][j] = s.charAt(j);
                    if (s.charAt(j) == '<' || s.charAt(j) == '^' || s.charAt(j) == '>' || s.charAt(j) == 'v') {
                        directionstate = s.charAt(j);
                        x = i;
                        y = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String command = br.readLine();

            for (int i = 0; i < N; i++) {
                char commandkey = command.charAt(i);
                if (commandkey == 'S') {
                    shoot();
                } else {
                    walk(commandkey);
                }
            }
            sb.append("#").append(testcase).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void walk(char a) {
        int nx = x, ny = y;
        if (a == 'U') {
            directionstate = '^';
            nx = x - 1;
        } else if (a == 'D') {
            directionstate = 'v';
            nx = x + 1;
        } else if (a == 'L') {
            directionstate = '<';
            ny = y - 1;
        } else if (a == 'R') {
            directionstate = '>';
            ny = y + 1;
        }

        arr[x][y] = directionstate;

        if (boundcheck(nx, ny) && arr[nx][ny] == '.') {
            arr[x][y] = '.';
            x = nx;
            y = ny;
            arr[x][y] = directionstate;
        }
    }

    public static void shoot() {
        int direction = 0;
        if (directionstate == '^') direction = 0;
        else if (directionstate == 'v') direction = 1;
        else if (directionstate == '<') direction = 2;
        else if (directionstate == '>') direction = 3;

        int k1 = x + dx[direction];
        int k2 = y + dy[direction];

        while (boundcheck(k1, k2)) {
            if (arr[k1][k2] == '*') {
                arr[k1][k2] = '.';
                return;
            } else if (arr[k1][k2] == '#') {
                return;
            }
            k1 += dx[direction];
            k2 += dy[direction];
        }
    }

    public static boolean boundcheck(int a, int b) {
        return a >= 0 && a < H && b >= 0 && b < W;
    }
}
