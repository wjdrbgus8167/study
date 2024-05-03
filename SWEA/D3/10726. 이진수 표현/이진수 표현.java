import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Solution{
	

	public static void main(String[] args)throws IOException{
		
		
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase=1;testcase<=t;testcase++)
		{
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
			int n =Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int count=0;
		
			for(int i=0;i<n;i++)
			{
				if(m%2==1) {
					count++;
				}
				m = m/2;
			}
				
			
			
			if(count==n)
			{
				
				sb.append("#"+testcase+" "+"ON"+"\n");
			}else {
				sb.append("#"+testcase+" "+"OFF"+"\n");
				
			}
			
		}
		System.out.println(sb);
	
	}
	
	
}