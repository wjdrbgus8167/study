import java.io.*;
import java.util.*;



public class Solution {

	static int pay[] = new int[3];
	static int timeline[];
	static int min;
	
	public static void main(String[] args)throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int testcase=1;testcase<=T;testcase++)
		{
			st = new StringTokenizer(br.readLine());
			
			pay[0] = Integer.parseInt(st.nextToken());
			pay[1]=Integer.parseInt(st.nextToken());
			pay[2]=Integer.parseInt(st.nextToken());
			
			int year = Integer.parseInt(st.nextToken());
			
			timeline= new int[12];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<12;i++)
			{
				timeline[i] = Integer.parseInt(st.nextToken());
				
			}
			
			min =Integer.MAX_VALUE;
			swimpay(0,0);
			min = Math.min(year,min);
			sb.append("#"+testcase+" "+min+"\n");
			
		}
		System.out.println(sb);
				
	}
	public static void swimpay(int count, int sum)
	{
		
		if(count>=12)
		{
			min=Math.min(min, sum);
			return ;
		}
	
		if(timeline[count]==0)
		{
			swimpay(count+1,sum);
		}else {
			swimpay(count+1,sum+(timeline[count]*pay[0]));
			swimpay(count+1,sum+pay[1]);
			swimpay(count+3,sum+pay[2]);
		}
		
	
	}
	
	
}