import java.io.*;
import java.util.*;
 
public class Solution {
   
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase=1;testcase<=t;testcase++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int cnt=0;
			int broken=0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
			{
				int status = Integer.parseInt(st.nextToken());
				if(status ==1)
				{
					broken=0;
				}else {
					broken++;
					if(broken==d)
					{
						cnt++;
						broken=0;
						
					}
				}
			}
			
			sb.append("#"+testcase+" "+cnt+"\n");
		}
		
		System.out.println(sb);
		
    }
	
	
  
}