import java.io.*;
import java.util.*;
 
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
 
            int sum = 0;
            for (int i = 1; i <= N; i++) {
 
                if (i % 2 == 0) {
                  
                    sum += (i * K);
                } else {
                   
                    sum += ((i - 1) * K) + 1;
                }
            }
            for (int i = 0; i < K; i++) {
                if (N % 2 == 0) {
                    sb.append(sum).append(" ");
                } else {
                    sb.append(sum + i).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}