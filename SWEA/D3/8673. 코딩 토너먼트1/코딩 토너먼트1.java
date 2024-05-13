import java.util.*;
import java.io.*;

public class Solution{
	
	
	
	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb=  new StringBuilder();
		for(int testcase=1;testcase<=tc;testcase++)
		{
			int k=Integer.parseInt(br.readLine());
			
			Queue<Integer> que = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<Math.pow(2, k);i++)
			{
				int a = Integer.parseInt(st.nextToken());
				
				que.add(a);
			}
			int x = 1;
			int result =0;
			
			for(int i=0;i<Math.pow(2,k)-1;i++)
			{
				int a = que.poll();
				int b = que.poll();
				if(a>b)
				{
					result += a-b;
					que.add(a);
				}else if(a<b) {
					result += b-a;
					que.add(b);
				}else if(a==b) {
					que.add(a);
				}
				
			}
			
			sb.append("#"+testcase+" "+result+"\n");
		}
		System.out.println(sb);
		
	}
	
}