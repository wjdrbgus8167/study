import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][3];
        int[][] cost = new int[N+1][3];

        StringTokenizer st;

        for(int i=1;i<=N;i++){

            st= new StringTokenizer(br.readLine());

            for(int j=0;j<3;j++){

                cost[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];

        // i번째 집을 R로 칠하면 i-1째는 G 또는 B
        // G이면 R또는 B, B이면 R또는 G
        for (int i = 2; i <= N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int ans = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));

        System.out.println(ans);
    }


}