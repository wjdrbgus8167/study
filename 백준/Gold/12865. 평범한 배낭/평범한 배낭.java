

import java.io.*;
import java.util.*;

public class Main {

	static int dp[][] ;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j=1;j<=K;j++) {
				dp[i][j]= dp[i-1][j];
				if(j>=w) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w]+v);	
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
		
	}

}
