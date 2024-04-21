import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

class Solution{
	
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=t;i++)
		{
			long x = Long.parseLong(br.readLine());
			long result =0;
			
			result = two(x);
			sb.append("#"+i+" "+result).append("\n");
			
		}
		System.out.println(sb);
	}
	public static long two(long x)
	{
	
		long max=x-1;
		for(int i=2;i<=Math.sqrt(x);i++)
		{
			if(x%i==0)
			{
				if(max>(i)+(x/i)-2)
				{
					max = (i)+(x/i)-2;
				}
		
			}
		}
		return max;
	}
}
