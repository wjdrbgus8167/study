import java.io.*;
import java.util.*;

class Solution{	
	
	public static void main(String[] args)throws IOException{
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int t = Integer.parseInt(br.readLine());
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int arr[] = new int[199];
	
	for(int i=0;i<t;i++)
	{
		arr[i]=Integer.parseInt(st.nextToken());
	}
	
	Arrays.sort(arr);
	
	int x = t/2;
	
	System.out.println(arr[x]);
	}
	

}