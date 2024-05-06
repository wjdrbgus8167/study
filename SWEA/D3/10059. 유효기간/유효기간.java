import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Arrays;

class Solution{
	

	public static void main(String[] args)throws IOException{
		
		
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int testcase=1;testcase<=t;testcase++)
		{
			String s = br.readLine();
			
			if(mm(s)&&yy(s))
			{
				sb.append("#"+testcase+" "+"AMBIGUOUS").append("\n");
			}else if(mm(s)&&!yy(s)) {
				sb.append("#"+testcase+" "+"MMYY").append("\n");
			}else if(!mm(s)&&yy(s))
			{
				sb.append("#"+testcase+" "+"YYMM").append("\n");
			}else {
				sb.append("#"+testcase+" "+"NA").append("\n");
			}
			
		}
		System.out.println(sb);
		
	}
	
	public static boolean mm(String x)
	{
		if(1<=Integer.parseInt(x.substring(0,2))&&Integer.parseInt(x.substring(0,2))<=12)
		{
			return true;
		}else {
			return false;
		}
	}
	public static boolean yy(String x)
	{
		if(1<=Integer.parseInt(x.substring(2,4))&&Integer.parseInt(x.substring(2,4))<=12)
		{
			return true;
		}else {
			return false;
		}
	}
}