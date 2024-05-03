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
        	char arr[] = new char[s.length()];
        	
        	for(int i=0;i<s.length();i++)
        	{
        		arr[i] = s.charAt(i);
        	}
        	
        	sb.append("#"+testcase+" ");
        	for(int i=arr.length-1;i>=0;i--)
        	{
        		switch(arr[i])
        		{
        		case 'b':
        			sb.append('d');
        			break;
        		case 'q':
        			sb.append('p');
        			break;
        		case 'p':
        			sb.append('q');
        			break;
        		case 'd':
        			sb.append('b');
        			break;
        			
        		}
        	}
        	
        	sb.append("\n");
        	
        }
        
        System.out.println(sb);
    }
}