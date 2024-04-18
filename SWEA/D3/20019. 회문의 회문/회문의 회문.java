import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution{

	public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++)
        {
            String s = br.readLine();
            int x=0;
            int y=s.length()/2+1;
            int count=0;
            for(int j=0;j<(s.length()-1)/2;j++)
            {
                if(s.charAt(x)==s.charAt(y))
                {
                    count++;
                }
                x++;
                y++;
            }
            if(count==s.length()/2)
            {
                sb.append("#"+(i+1)+" "+"YES").append("\n");
            }else{
                sb.append("#"+(i+1)+" "+"NO").append("\n");
            }
        }
        System.out.println(sb);
        
    }
     
}