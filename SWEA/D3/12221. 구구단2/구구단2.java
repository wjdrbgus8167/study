import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution{
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=t;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a>=10||b>=10)
			{
				sb.append("#"+i+" "+(-1)).append("\n");
			}else {
				sb.append("#"+i+" "+(a*b)).append("\n");
			}
		}
		System.out.println(sb);
	}
}