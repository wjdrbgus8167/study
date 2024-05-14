import java.io.*;
import java.util.*;
 
public class Solution {
   
	public static void main(String[] args) throws Exception {
        
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int testcase=1;testcase<=t;testcase++)
		{
			st = new StringTokenizer(br.readLine()," ");
			
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int max = B+E;
			int min = B-E;
			int arr[] = new int[N];
			int count=0;
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
				
			}
			for(int i=0;i<N;i++)
			{
				
				int x=1;
				int y= arr[i]*x;
				
				if(arr[i]>max)
				{
					continue;
				}else 
				{
					while(y<=max)
					{			
						y= arr[i]*x;
						if(y>=min&&y<=max)
						{
							count++;
							break;
						}else {
							x++;
						}
							
					}
				}
			}
			sb.append("#"+testcase+" "+count+"\n");
			
		}
		System.out.println(sb);
    }
 
  
}