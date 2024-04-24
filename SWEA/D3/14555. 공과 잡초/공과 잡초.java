import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
       for(int i=1;i<=T;i++)
       {
    	   String s = br.readLine();
    	   int count =0;
    	   for(int j=0;j<s.length()-1;j++)
    	   {
    		
    		   if(s.charAt(j)=='('&&(s.charAt(j+1)=='|'||s.charAt(j+1)==')'))
    		   {
    			   count++;
    		   }else if(s.charAt(j)=='|'&&s.charAt(j+1)==')')
    		   {
    			   count++;
    		   }
    	   }
    	   sb.append("#"+i+" "+count).append("\n");
    	   
       }
       System.out.println(sb);
    }
    

}
