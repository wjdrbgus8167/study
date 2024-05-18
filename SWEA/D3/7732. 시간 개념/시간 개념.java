import java.io.*;
import java.util.*;
 
public class Solution {
   
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase=1;testcase<=t;testcase++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(),":");
			
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(),":");
			
			int n_a=Integer.parseInt(st.nextToken());
			int n_b=Integer.parseInt(st.nextToken());
			int n_c=Integer.parseInt(st.nextToken());
			
			
			
			if(c>n_c)
			{
				n_c = 60-c+n_c;
				n_b--;
			}else {
				n_c=n_c-c;
			}
			
			if(b>n_b)
			{
				n_b = 60-b+n_b;
				n_a--;
			}else {
				n_b=n_b-b;
			}
			
			if(a>n_a)
			{
				n_a = 24-a+n_a;
			}else {
				n_a=n_a-a;
			}
			
			sb.append("#"+testcase+" ");
			sb.append(time(n_a)+":"+time(n_b)+":"+time(n_c)+"\n");
			
		}
		System.out.println(sb);
		
    }
	public static String time(int time)
	{
		if(time >9)
		{
			return time+"";
		}
		return "0"+time;
	}
	
  
}