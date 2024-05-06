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
			
			int count=0;
			int n =Integer.parseInt(br.readLine());
			int arr[][] = new int[n][2];
			
			for(int i=0;i<n;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr,new Comparator<int[]>() {
				public int compare(int[] a1,int []a2 ) {
					if(a1[0]==a2[0])
					{
						return a1[1]-a2[1];
					}else {
						return a1[0]-a2[0];
					}
				}
			});
			
			for(int i=0;i<n-1;i++)
			{
				for(int j=i+1;j<n;j++)
				{
					if(arr[i][1]>arr[j][1])
					{
						count++;
					}
				}
			}
			
			sb.append("#"+testcase+" "+count).append("\n");
			
		}
		System.out.println(sb);
		
	}
	
	
}