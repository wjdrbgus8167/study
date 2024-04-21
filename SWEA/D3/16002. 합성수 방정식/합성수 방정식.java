
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Random;

class Solution{
	
	
	public static void main(String[] args)throws IOException{
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int i =1;i<=t;i++)
		{
			int n = Integer.parseInt(br.readLine());
			
			int m = hp(n);
			sb.append("#"+i+" "+(m)+" "+(m-n)).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static int hp(int n)
	{
		Random random = new Random();
		int result=0;
		while(true)
		{
			int x = random.nextInt((int) Math.pow(10,9))+2;

			if(check(x)&&check(x-n))
			{
				result=x;
				break;
			}
			
		}
		return result;
	}
	public static boolean check(int x)
	{
		int count=0;
		for(int j=2;j<=Math.sqrt(x);j++)
		{
			if(x%j==0)
			{
				count++;
			}
			if(count>=2)
			{
				return true;
				
			}
		}
		return false;
	
	}
}
