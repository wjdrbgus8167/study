import java.util.*;
import java.io.*;

public class Solution{
  
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=T;testcase++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			long A =Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			long m = make(A,B);
			sb.append("#"+testcase+" "+m).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static long make(long A,long B)
	{
		if(A==B)
		{
			return 0;
		}else  if(A>B)
		{
			return -1;
		}
		long d = Math.abs(A-B);
		
		if(d==1)
		{
			return -1;
		}else if(d%2==1)
		{
			return (long)((d-1)/2);
		}else {
			return (long)(d/2);
		}
	}
	
}