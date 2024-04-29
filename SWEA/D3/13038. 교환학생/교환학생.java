import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution{
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int T = 1;T<=t;T++)
		{
			int n= Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			boolean arr[] = new boolean[7];
			for(int i=0;i<7;i++)
			{
				int x = Integer.parseInt(st.nextToken());
				if(x == 1)
				{
					arr[i]=true;
				}
			}
			
			int count1=0;
			int count2=0;
			int x=0;
			int min =Integer.MAX_VALUE;
			for(int i=0;i<7;i++)
			{
				count1=0;
				count2=0;
				x=i;
				while(true)
				{
				
					if(count2==n)
					{
						break;
					}
					
					if(x==7)
					{
						x=0;
					}
					
					if(arr[x])
					{
						count2++;
					}
					if(count2>0)
					{
						count1++;
					}
					x++;
				}
				if(min>count1)
				{
					min =count1;
				}
			}
			
			sb.append("#"+T+" "+min).append("\n");
		}
		System.out.println(sb);
	}
}