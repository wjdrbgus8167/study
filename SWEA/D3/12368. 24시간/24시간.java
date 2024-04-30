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
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(A+B>=24)
			{
				sb.append("#"+testcase+" "+Math.abs(24-(A+B))).append("\n");
				
			}else {
				sb.append("#"+testcase+" "+(A+B)).append("\n");
			}
		}
		System.out.println(sb);
	}
}