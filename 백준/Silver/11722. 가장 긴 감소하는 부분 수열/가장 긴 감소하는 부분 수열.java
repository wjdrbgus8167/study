import java.util.*;
import java.io.*;

class Main{


    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        for(int i=0;i<N;i++){

            dp[i] = 1;

            for(int j=0;j<i;j++){

                if(A[j]>A[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }

            }
            answer = Math.max(answer,dp[i]);
        }

        System.out.println(answer);
    }


}
