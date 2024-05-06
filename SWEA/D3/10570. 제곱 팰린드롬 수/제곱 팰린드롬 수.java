import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Solution{
	

	public static void main(String[] args)throws IOException{
		
		
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=t;testcase++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int count=0;
			for(int i=a;i<=b;i++)
			{
				String s = Integer.toString(i);
				
				if(check(s))
				{
					if(Math.sqrt(i)%1==0)
					{
						String ss  = Integer.toString((int)Math.sqrt(i));
						if(check(ss))
						{
							count++;
						}
					}
				}
			}
			
			sb.append("#" +testcase+" "+count).append("\n");
		}
		System.out.println(sb);
		
	}
	public static boolean check(String x)
	{
		int y = x.length()-1;
		
		
		if(x.length()==1)
		{
			return true;
		}else {
		
			for(int i=0;i<x.length()/2;i++)
			{
				if(x.charAt(i)!=x.charAt(y))
				{
					return false;
				}else {
					y--;
				}
			}
		}
		return true;
		
	}
	
	
}