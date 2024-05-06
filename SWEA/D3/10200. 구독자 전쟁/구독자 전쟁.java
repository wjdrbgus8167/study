import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Arrays;

class Solution{
	

	public static void main(String[] args)throws IOException{
		
		
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=t;testcase++)
		{
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			sb.append("#"+testcase+" ");
			
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(Math.min(a,b)+" ");
			
			if(n<a+b)
			{
				sb.append(a+b-n);
			}else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	
}