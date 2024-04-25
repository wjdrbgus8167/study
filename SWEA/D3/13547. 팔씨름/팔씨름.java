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
        	
        	
        	String s = br.readLine();
        	int count1=0;
        
        	for(int i=0;i<s.length();i++)
        	{
        		
        		if(s.charAt(i)=='x')
        		{
        			count1++;
        		}
        	}
        	if(count1>=8)
        	{
        		sb.append("#"+t+" "+"NO").append("\n");
        	}else {
        		sb.append("#"+t+" "+"YES").append("\n");
        	}
        	
        }
      
        System.out.println(sb);
        
    }
    
   
}