import java.io.*;
import java.util.*;
 
public class Solution{
	
	public static void main(String[] args)throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t =Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase=1;testcase<=t;testcase++)
		{
			HashSet<Character> set = new HashSet<>();
			
			char arr[] = br.readLine().toCharArray();
			
			for(char a:arr)
			{
				set.add(a);
			}
			sb.append("#"+testcase+" "+set.size()).append("\n");
		}
		System.out.println(sb);
	}
}