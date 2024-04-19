import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

class Solution {
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase=1;testcase<=T;testcase++)
		{
			
			int N = Integer.parseInt(br.readLine());
			
			Long discount[] = new Long[N];
			long arr[] = new long[2*N];
			boolean te[] = new boolean[2*N];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<2*N;i++)
			{
				arr[i] = Long.parseLong(st.nextToken());
				te[i] =true;
			}
			
			sb.append("#"+testcase+" ");
			int idx=0;
			for(int i=0;i<2*N;i++)
			{
				
				if(te[i])
				{
					long cur = arr[i];
					for(int j=i;j<2*N;j++)
					{
						long price = arr[i]*4/3;
						if(price==arr[j]&&te[j])
						{
							discount[idx] =cur;
							te[i] =false;
							te[j] =false;
							idx++;
							break;
						}
					}
					
				}
				
			}
			for(int n=0;n<N;n++)
			{
				sb.append(discount[n]+" ");
			}
			sb.append("\n");
		
		}
		System.out.println(sb);
		
	}
}
