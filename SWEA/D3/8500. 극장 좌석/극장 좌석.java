import java.io.*;
import java.util.*;
 
public class Solution {
   
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testcase = 1; testcase <= t; testcase++)
        {
         
        	int n = Integer.parseInt(br.readLine());
        	int arr[] = new int[n];
        	int max =0;
        	int answer= 0;
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	for(int i=0;i<n;i++)
        	{
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	for(int i=0;i<n;i++)
        	{
        		max = Math.max(max, arr[i]);
        		answer += arr[i]+1;
        	}
        	answer +=max;
        	sb.append("#"+testcase+" "+answer+"\n");
        }
        System.out.println(sb);
    }
 
  
}