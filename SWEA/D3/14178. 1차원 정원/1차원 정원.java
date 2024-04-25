import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

class Solution {
	
    public static void main(String[] args)throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <=T ; t++) 
        {
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	int n = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int x=1;
        	while(true)
        	{
        		if((d*2+1)*x>=n)
        		{
        			break;
        		}else {
        			x++;
        		}
        	}
        	
        	sb.append("#"+t+" "+x).append("\n");
        	
        }
        System.out.println(sb);
        
    }
}