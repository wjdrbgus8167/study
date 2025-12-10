import java.io.*;
import java.util.*;

public class Main {

    static int[] stair;
    static int[] dp;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        stair = new int[n+1];
        dp  = new int[n+1];

        for(int i=1;i<=n;i++){
            stair[i] = Integer.parseInt(br.readLine());
            dp[i] =-1;
        }
        dp[0]=stair[0];
        dp[1]=stair[1];

        if(n>=2) dp[2] = stair[1]+stair[2];

        System.out.println(find(n));
    }

    private static int find(int n){

        if(dp[n]==-1){
            dp[n] = Math.max(find(n-2),find(n-3)+stair[n-1])+stair[n];
        }

        return dp[n];
    }
}
