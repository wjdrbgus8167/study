
class Solution {
    int solution(int[][] land) {
        int N = land.length;

        int[][] dp = new int[N][4];

        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {

                int max = 0;

               
                for (int k = 0; k < 4; k++) {

                    if (j == k) continue;

                    max = Math.max(max, dp[i-1][k]);
                }

                dp[i][j] = land[i][j] + max;
            }
        }

    
        int answer = 0;

        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, dp[N-1][j]);
        }

        return answer;
    }
}
