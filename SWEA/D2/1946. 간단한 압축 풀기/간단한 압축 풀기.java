import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution{

	
	public static StringBuilder sb = new StringBuilder();
	public static  int count=0;
	    public static void main(String[] args)throws IOException
	    {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int T = Integer.parseInt(br.readLine());
	       
	        for(int i=0;i<T;i++)
	        {
	            int N = Integer.parseInt(br.readLine());
	            
	            sb.append("#"+(i+1)).append("\n");
	            for(int j=0;j<N;j++)
	            {
	            	StringTokenizer st = new StringTokenizer(br.readLine()," ");
	                String x = st.nextToken();
	                int y = Integer.parseInt(st.nextToken());
	                make(x,y);
	               
	            }
	            count =0;
	            sb.append("\n");
	        }
	        System.out.println(sb);
	    }
	    
	    public static void make(String x, int y)
	    {
	    	
	    	 
	        for(int i=0;i<y;i++)
	        {
	        	
	            if(count==10)
	            {
	                sb.append("\n");
	                sb.append(x);
	                count=0;
	                count++;
	            }else {
	            	count++;
	                sb.append(x);
	                
	            }
	           
	        }
	    }
}


