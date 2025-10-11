import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 2]; // 상담 기간
        int[] P = new int[N + 2]; // 보상

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = i일 아침(시작 시점)에 확보한 최대 수익
        long[] dp = new long[N + 2];

        for (int i = 1; i <= N + 1; i++) {

            // i일에 상담을 안 하면, 그대로 다음 날로 돈을 전파
            if (i+1<=N+1) {
                dp[i+1]= Math.max(dp[i+1],dp[i]);
            }

            // i일에 상담을 하면, 상담 종료 시점에 수익 반영
            if (i<=N&&i+T[i]<=N+1){
                dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
            }
        }

        System.out.println(dp[N + 1]);
    }
}
