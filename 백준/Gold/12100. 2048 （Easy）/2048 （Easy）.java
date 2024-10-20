

import java.io.*;
import java.util.*;

class Point7 {
    int weight;
    boolean engraft;

    public Point7(int weight, boolean engraft) {
        this.weight = weight;
        this.engraft = engraft;
    }
}

public class Main {

    static int N;
    static Point7 map[][];
    static Point7 copymap[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    // 하 우 상 좌 
    static int maxValue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new Point7[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = new Point7(Integer.parseInt(st.nextToken()), false);
            }
        }
        maxValue = 0;

        // dfs를 5번만 실행하여 모든 경우를 확인
        dfs(0, map);
        System.out.println(maxValue);
    }

    public static void dfs(int cnt, Point7[][] currentMap) {
        if (cnt == 5) {
            // 최대값 확인
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxValue = Math.max(maxValue, currentMap[i][j].weight);
                }
            }
            return;
        }

        // 현재 상태의 맵을 복사 (깊은 복사)
        Point7[][] tempMap = new Point7[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempMap[i][j] = new Point7(currentMap[i][j].weight, false);
            }
        }

        // 4가지 방향으로 이동 시도
        for (int i = 0; i < 4; i++) {
            Point7[][] movedMap = move(i, tempMap);
            dfs(cnt + 1, movedMap);
        }
    }

    // 방향에 맞춰서 이동하는 함수
    public static Point7[][] move(int dir, Point7[][] inputMap) {
        Point7[][] movedMap = new Point7[N][N];
        
        // 복사 (깊은 복사)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                movedMap[i][j] = new Point7(inputMap[i][j].weight, false);
            }
        }

        resetEngraft(movedMap); // 이동마다 engraft 상태 초기화

        if (dir == 0) { // 하
            for (int j = 0; j < N; j++) {
                for (int i = N - 2; i >= 0; i--) {
                    if (movedMap[i][j].weight != 0) {
                        makeMove(i, j, 0, movedMap);
                    }
                }
            }
        } else if (dir == 1) { // 우
            for (int i = 0; i < N; i++) {
                for (int j = N - 2; j >= 0; j--) {
                    if (movedMap[i][j].weight != 0) {
                        makeMove(i, j, 1, movedMap);
                    }
                }
            }
        } else if (dir == 2) { // 상
            for (int j = 0; j < N; j++) {
                for (int i = 1; i < N; i++) {
                    if (movedMap[i][j].weight != 0) {
                        makeMove(i, j, 2, movedMap);
                    }
                }
            }
        } else if (dir == 3) { // 좌
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (movedMap[i][j].weight != 0) {
                        makeMove(i, j, 3, movedMap);
                    }
                }
            }
        }

        return movedMap;
    }

    public static void makeMove(int x, int y, int d, Point7[][] movedMap) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (boundchecking(nx, ny)) {
            if (movedMap[nx][ny].weight == 0) {
                movedMap[nx][ny].weight = movedMap[x][y].weight;
                movedMap[x][y].weight = 0;
                makeMove(nx, ny, d, movedMap);
            } else if (movedMap[nx][ny].weight == movedMap[x][y].weight && !movedMap[nx][ny].engraft) {
                movedMap[nx][ny].weight += movedMap[x][y].weight;
                movedMap[nx][ny].engraft = true;
                movedMap[x][y].weight = 0;
            }
        }
    }

    public static boolean boundchecking(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static void resetEngraft(Point7[][] movedMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                movedMap[i][j].engraft = false;
            }
        }
    }
}
