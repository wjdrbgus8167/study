import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int m;
    static int arr[][];
    static int dp[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; 
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0; 

        for (int i = 0; i < 4; i++) {
            int kx = dx[i] + x;
            int ky = dy[i] + y;

            if (kx >= 0 && ky >= 0 && kx < n && ky < m) {
                if (arr[x][y] > arr[kx][ky]) {
                    dp[x][y] += dfs(kx, ky);
                }
            }
        }

        return dp[x][y];
    }
}
