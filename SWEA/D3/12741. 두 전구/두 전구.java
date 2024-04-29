import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution{
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
	
		StringBuilder sb = new StringBuilder();
		for(int testcase =1;testcase<=t;testcase++)
		{
			int arr[] = new int[100] ;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			int start = Math.max(A,C);
			int end = Math.min(B,D);
			int ans = Math.max(0,end-start);
			sb.append("#"+testcase+" "+ans).append("\n");
			
		}
		System.out.println(sb);
	}
}