import java.util.*;
import java.io.*;

class Main{


    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] dp = new int[N];
        int[] dp1 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        for(int i=0;i<N;i++){

            dp[i] = 1;

            for(int j=0;j<i;j++){

                if(A[j]<A[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }

            }
        }

        for(int i=N-1;i>=0;i--){

            dp1[i] = 1;

            for(int j=N-1;j>i;j--){

                if(A[j]<A[i]){
                    dp1[i] = Math.max(dp1[i],dp1[j]+1);
                }

            }

        }

        for(int i=0;i<N;i++){

            answer = Math.max(answer,dp[i]+dp1[i]-1);

        }
        System.out.println(answer);
    }


}
