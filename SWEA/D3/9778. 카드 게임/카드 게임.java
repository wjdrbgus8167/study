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
			
			int arr[]= {0,0,4,4,4,4,4,4,4,4,16,4};
			int m = 52;
			int sum=0;
			
			for(int i=0;i<n;i++)
			{
				int x = Integer.parseInt(br.readLine());
				arr[x]--;
				sum = sum+x;
			}
			int count1=0;
			int count2=0;
			for(int i=2;i<=11;i++)
			{
				if(arr[i]!=0)
				{
					if(sum+i>=21)
					{
						count1++;
					}else {
						count2++;
					}
				}
			}
			if(count1>=count2)
			{
				System.out.println("#"+testcase+" "+"STOP");
			}else {
				System.out.println("#"+testcase+" "+"GAZUA");
			}
		}
		
	}
	
	
}