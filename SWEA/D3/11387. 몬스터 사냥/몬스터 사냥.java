

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

class Solution{
	

    public static void main(String[] args)throws IOException 
    {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int t = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	for(int testcase=1;testcase<=t;testcase++)
    	{
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		int D = Integer.parseInt(st.nextToken());
    		int L = Integer.parseInt(st.nextToken());
    		int N = Integer.parseInt(st.nextToken());
    		
    		long x=0;
    		
    		double per= L*0.01;
    		
    		for(int i=0;i<N;i++)
    		{
    			x +=(D*(1+(i*(per))));	
    		}
    		
    		
    		sb.append("#"+testcase+" "+x).append("\n");
    	}
    	System.out.println(sb);
    }
}