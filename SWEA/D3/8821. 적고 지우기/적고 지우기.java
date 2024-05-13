import java.util.*;
import java.io.*;

public class Solution{
	
	
	
	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb=  new StringBuilder();
		for(int testcase=1;testcase<=tc;testcase++)
		{
			HashSet<Character> set = new HashSet<>();
			
			String s =br.readLine();
			
			for(int i =0;i<s.length();i++)
			{
				if(set.contains(s.charAt(i)))
				{
					set.remove(s.charAt(i));
				}else {
					set.add(s.charAt(i));	
				}
				
				
			}
			sb.append("#"+testcase+" "+set.size()+"\n");
		}
		System.out.println(sb);
		
	}
	
}