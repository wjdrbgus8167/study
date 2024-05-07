import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Arrays;

class Solution{
	

	public static void main(String[] args)throws IOException{
		
		
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int testcase=1;testcase<=t;testcase++)
		{
			
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for(int i=1;i<=n;i++)
			{
				int x=Integer.parseInt(st.nextToken());
				arr[x]++;
			}
			int count=0;
			for(int i=1;i<=n;i++)
			{
				if(arr[i]>=2)
				{
					count++;
				}
			}
		
			if(count>=1)
			{
				System.out.print("#"+testcase+" "+"No"+"\n");
			}else {
				System.out.print("#"+testcase+" "+"Yes"+"\n");
			}
		}
		
	
	}
	
	
}