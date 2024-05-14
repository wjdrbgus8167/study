import java.io.*;
import java.util.*;
 
public class Solution {
   
	public static void main(String[] args) throws Exception {
        
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testcase=1;testcase<=t;testcase++)
		{
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> que = new LinkedList<>();
		
			for(int i=0;i<n;i++)
			{
				que.add(Integer.parseInt(st.nextToken()));
			}
			
			int x = que.poll();
			
			
			for(int i=0;i<n-1;i++)
			{
				int a =x+ que.peek();
				int b =x*que.peek();
				
				int max = Math.max(a, b);
				que.poll();
				x =max;
				
			}
			sb.append("#"+testcase+" "+x+"\n");
		}
		System.out.println(sb);
    }
 
  
}