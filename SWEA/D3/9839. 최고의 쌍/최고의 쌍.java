import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
	

	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=t;testcase++)
		{
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<n;i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = -1;
			for(int i=0;i<n-1;i++)
			{
				for(int j=i+1;j<n;j++)
				{
					int x = arr[i]*arr[j];
					
					if(check(x))
					{
						if(max<x)
						{
							max =x;
						}
					}
				}
			}
			System.out.print("#"+testcase+" "+max+"\n");
		}
		
	}
	public static boolean check(int x)
	{
		String s = Integer.toString(x);
		int y = s.charAt(0)-48;
		for(int i=0;i<s.length();i++)
		{
			if(y!=s.charAt(i)-48)
			{
				return false;
			}else {
				y++;
			}
		}
		return true;
	}
	
}