
import java.io.*;
import java.util.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main{

    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static int[] dx = {0, -1, 0, 1}; 
    static int[] dy = {1, 0, -1, 0}; 
    static int[] combi;
    static int minSection, sum;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if (a != 0 && a != 6) {
                    list.add(new Node(i, j));
                }
            }
        }
        combi = new int[list.size()];
        minSection = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(minSection);
    }

    public static void dfs(int cnt) {
        if (cnt == list.size()) {
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < list.size(); i++) {
                observation(list.get(i), combi[i]);
            }

            sum = 0;
            countingSection();
            minSection = Math.min(minSection, sum);

            return;
        }

        for (int i = 0; i < 4; i++) {
            combi[cnt] = i;
            dfs(cnt + 1);
        }
    }

    public static void observation(Node node, int dir) {
        int x = node.x;
        int y = node.y;
        int cctvType = map[x][y];

        if (cctvType == 1) {
            observeDirection(x, y, dir);
        } else if (cctvType == 2) {
            observeDirection(x, y, dir);
            observeDirection(x, y, (dir + 2) % 4); 
        } else if (cctvType == 3) {
            observeDirection(x, y, dir);
            observeDirection(x, y, (dir + 1) % 4); 
        } else if (cctvType == 4) {
            observeDirection(x, y, dir);
            observeDirection(x, y, (dir + 1) % 4); 
            observeDirection(x, y, (dir + 2) % 4); 
        } else if (cctvType == 5) {
            for (int i = 0; i < 4; i++) {
                observeDirection(x, y, i);
            }
        }
    }

    public static void observeDirection(int x, int y, int dir) {
        while (true) {
            x += dx[dir];
            y += dy[dir];

            if (!boundCheck(x, y) || copyMap[x][y] == 6) {
                break;
            }

            if (copyMap[x][y] == 0) {
                copyMap[x][y] = 7;
            }
        }
    }

    public static void countingSection() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    sum++;
                }
            }
        }
    }

    public static boolean boundCheck(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
