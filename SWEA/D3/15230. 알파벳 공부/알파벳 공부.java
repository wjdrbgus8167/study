import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=T;i++)
        {
        	int count=0;
        	String x = br.readLine();
        	for(int j=0;j<x.length();j++)
        	{
        		if(x.charAt(j)-j==97)
        		{
        			count++;
        		}else {
        			break;
        		}
        	}
        	sb.append("#"+i+" "+count).append("\n");
        }
        System.out.println(sb);
    }
}
