

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
        	String x= br.readLine();
        	HashMap<Integer,Character> map = new HashMap<>();
        	int max =0;
        	for(int i=0;i<x.length();i++)
        	{
        		map.put(i,x.charAt(i));
        		if(max<x.charAt(i)-48)
        		{
        			max=x.charAt(i)-48;
        		}
        	}
        	boolean po = false;
        	for(int i=2;i<=max;i++)
        	{
        		String y = Integer.toString(Integer.parseInt(x)*i);
        		int count=0;
        		if(y.length()>x.length())
        		{
        			break;
        		}
        		for(int j=0;j<x.length();j++)
        		{
        			if(map.containsValue(y.charAt(j)))
        			{
        				count++;
        			}
        				
        		}
        		
        		if(count==x.length())
        		{
        			po = true;
        			break;
        		}
        		
        	}
        	if(po==true)
        	{
        		sb.append("#"+t+" "+"possible").append("\n");
        	}else {
        		sb.append("#"+t+" "+"impossible").append("\n");
        	}
    
        }

        System.out.println(sb);
    }
}