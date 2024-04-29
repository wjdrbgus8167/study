import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class Solution{
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		String arr[] = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		StringBuilder sb = new StringBuilder();
		
		for(int testcase=1;testcase<=t;testcase++)
		{
			String s = br.readLine();
			for(int i=0;i<7;i++)
			{
				if(s.equals(arr[i]))
				{
					sb.append("#"+testcase+" "+(7-i)).append("\n");
				}
			}
			
		}
		System.out.println(sb);
	}
}