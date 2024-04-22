import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Random;

class Solution{
	
	public static void main(String[] args)throws IOException{

	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=t;i++)
		{
			sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String S = st.nextToken();
			String T = st.nextToken();
			
			for(int j=0;j<T.length();j++)
			{
				sb.append(S);
			}
			String s_n = sb.toString();
			
			sb = new StringBuilder();
			for(int k=0;k<S.length();k++)
			{
				sb.append(T);
			}
			String t_n = sb.toString();
			
			sb = new StringBuilder();
			
			if(s_n.equals(t_n))
			{
				System.out.println("#"+i+" "+"yes");
			}else {
				System.out.println("#"+i+" "+"no");
			}
		
		}
		
	}
}


