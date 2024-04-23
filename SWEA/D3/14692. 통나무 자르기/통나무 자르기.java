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
        	int x = Integer.parseInt(br.readLine());
        	
        
        	if(x%2==0)
        	{
        		sb.append("#"+i+" "+"Alice").append("\n");
        	}else {
        		sb.append("#"+i+" "+"Bob").append("\n");
        	}
        	
        }
        System.out.println(sb);
    }
    
    
}
