import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Random;

class Solution{
	
	public static int a;
	public static int b;
	public static int c;
	public static int result=0;
	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=t;i++)
		{
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			a= Integer.parseInt(st.nextToken());
			b= Integer.parseInt(st.nextToken());
			c= Integer.parseInt(st.nextToken());
				
			int v =dfs(a,b,c);		
			
			
			sb.append("#"+i+" "+v).append("\n");
			result=0;
		}
		
		System.out.println(sb);
	}
	
	public static int dfs(int a,int b,int c)
	{
		
		if (a < b && b < c) {
            return 0;
        }else if(a==1&&b==1){
        	result= -1;
        }

		
        if (a > 1&&a>=b) {
            result++;
        	dfs(a-1, b, c);
        }else if (b > 1&&b>=c) {
        	result++;
            dfs(a, b-1, c);
        }

        return result;
	}
}


