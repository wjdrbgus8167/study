import java.util.*;
import java.io.*;

public class Solution{
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int testcase=1;testcase<=t;testcase++)
		{
			
			int n = Integer.parseInt(br.readLine());
			
			Stack<Integer> stack = new Stack<>();
			
			for(int i=0;i<n;i++)
			{
				int a = Integer.parseInt(br.readLine());
				
				if(a==0)
				{
					stack.pop();
				}else {
					stack.add(a);
				}
			}
			
			int result=0;
			
			while(!stack.isEmpty())
			{
				result += stack.pop();
			}
				
			
			sb.append("#"+testcase+" "+result+"\n");
		}
		
		System.out.println(sb);
	}
}