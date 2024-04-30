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
    		String s= br.readLine();
    		HashSet<Character> set = new HashSet<>();
    		for(int i=0;i<4;i++)
    		{
    			set.add(s.charAt(i));
    		}
    		if(set.size()==2)
    		{
    			sb.append("#"+testcase+" "+"Yes").append("\n");
    		}else {
    			sb.append("#"+testcase+" "+"No").append("\n");
    		}
    	}
    	System.out.println(sb);
    }
}