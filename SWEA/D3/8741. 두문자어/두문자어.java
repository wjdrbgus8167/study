import java.util.*;
import java.io.*;

public class Solution{
	
	
	
	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb=  new StringBuilder();
		for(int testcase=1;testcase<=tc;testcase++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			sb.append("#"+testcase+" ");
			for(int i=0;i<3;i++)
			{
				String a = st.nextToken();
				String v =a.toUpperCase();
				sb.append(v.charAt(0));
				
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
}