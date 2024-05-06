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
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=t;testcase++)
		{
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int arr[] = new int[n];
			int sum =0;
			int count=0;
			for(int i=0;i<n;i++)
			{
				 arr[i] = Integer.parseInt(st.nextToken());
				sum = sum+arr[i];
			}
			double avg = (double)sum/n;
			
			for(int i=0;i<n;i++)
			{
				if(avg>=arr[i])
				{
					count++;
				}
			}
			sb.append("#"+testcase+" "+count).append("\n");
		}
		System.out.println(sb);
		
	}
	
	
}