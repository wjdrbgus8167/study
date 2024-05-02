import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
 
        for (int testcase = 1; testcase <= T; testcase++) 
        {
            
        	String s = br.readLine();
        	
        	ArrayList<Character> list = new ArrayList<>();
        	
        	for(int i=0;i<s.length();i++)
        	{
        		if(list.contains(s.charAt(i)))
        		{
        			list.remove(list.indexOf(s.charAt(i)));
        		}else {
        			list.add(s.charAt(i));
        		}
        	}
        	
        
        	list.sort(Comparator.naturalOrder());
        	if(list.size()==0)
        	{
        		sb.append("#"+testcase+" "+"Good").append("\n");
        	}else {
        		sb.append("#"+testcase+" ");
        		for(int i=0;i<list.size();i++)
        		{
        			sb.append(list.get(i));
        		}
        		sb.append("\n");
        	}
        	
        }
        
        System.out.println(sb);
    }
}