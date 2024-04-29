import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution {
	
	
	public static void main(String[] args)throws IOException{
		
		 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
         for(int test_case = 1; test_case <= T; test_case++)
         {
             String s = br.readLine();
             char[] cArr = s.toCharArray();
             
             int max = Integer.parseInt(s); 
             int min = max;

             for (int i = 0; i < cArr.length - 1; i++) 
             {
                
            	 for (int j = i + 1; j < cArr.length; j++) 
            	 {
                     char tmp =  cArr[i];
                     cArr[i] = cArr[j];
                     cArr[j] = tmp;
                     if(cArr[0] != 48 && Integer.parseInt(String.valueOf(cArr)) < min)
                     {
                         min = Integer.parseInt(String.valueOf(cArr));
                     }
                     if(cArr[0] != 48 && Integer.parseInt(String.valueOf(cArr)) > max)
                     {
                         max = Integer.parseInt(String.valueOf(cArr));
                     }
                     tmp =  cArr[i];
                     cArr[i] = cArr[j];
                     cArr[j] = tmp;
                 }
             }
             sb.append("#" + test_case + " " + min + " " + max).append("\n");
         }
    
         System.out.println(sb);
	}
	
   
}