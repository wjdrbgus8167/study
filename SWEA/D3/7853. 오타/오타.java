import java.io.*;
import java.util.*;
 
public class Solution {
   
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase=1;testcase<=t;testcase++)
		{
			
			char [] s = br.readLine().toCharArray();
			long result=1;
			
				if(s[0]!=s[1])
				{
					result *=2;
				}else {
					result *=1;
				}
			
				if(s[s.length-1]!=s[s.length-2])
				{
					result *=2;
				}else {
					result *=1;
				}
				
		
			long x =1000000007;
			for(int i=1;i<s.length-1;i++)
			{
				HashSet<Character> set = new HashSet<>();
				set.add(s[i-1]);
				set.add(s[i]);
				set.add(s[i+1]);
				
				result =result*set.size()%x;
				
			}
			
			
			sb.append("#"+testcase+" "+result+"\n");
		}
		System.out.println(sb);
		
    }
	
	
  
}