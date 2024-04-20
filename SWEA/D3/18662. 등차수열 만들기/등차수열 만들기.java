import java.util.*;
import java.io.IOException;
import java.io.*;

public class Solution{
  
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase=1;testcase<=T;testcase++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int arr[] = new int[3];
			for(int i=0;i<3;i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			double x = Math.abs((2*arr[1]-arr[0]-arr[2])); 
			
			sb.append("#"+testcase+" "+(double)(x/2));
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	
}