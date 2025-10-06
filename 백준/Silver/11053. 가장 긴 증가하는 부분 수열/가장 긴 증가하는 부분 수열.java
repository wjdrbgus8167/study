import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N];
        int ans = 0;

        for (int i = 0; i < N; i++) {

            dp[i] = 1;

            for (int j = 0; j < i; j++) {

                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
