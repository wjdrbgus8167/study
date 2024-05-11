import java.util.*;
import java.io.*;

public class Solution{
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase =1;testcase<=t;testcase++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int arr[] = new int[n];
			st = new StringTokenizer(br.readLine()," ");
			for(int i =0;i<n;i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max= -1;
			for(int i=0;i<n-1;i++)
			{
				for(int j=i+1;j<n;j++)
				{
					int result = arr[i]+arr[j];
					if(result<=m&&max<result)
					{
						max = result;
					}
				}
			}
			
			sb.append("#" +testcase+" "+max+"\n");
		}
		System.out.println(sb);
	}
}