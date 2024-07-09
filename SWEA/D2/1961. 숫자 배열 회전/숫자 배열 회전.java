import java.io.*;
import java.util.*;

class Solution{	
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
            
            int a = Integer.parseInt(br.readLine());
            int arr[][] = new int[a][a];
            for(int i=0; i<a;i++) 
            {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<a;j++) 
                {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }

           
            int[][] rotated90 = new int[a][a];
            int[][] rotated180 = new int[a][a];
            int[][] rotated270 = new int[a][a];

            
            for (int i = 0; i < a; i++) 
            {
                for (int j = 0; j <a; j++) {
                    rotated90[j][a-1-i] = arr[i][j];
                }
            }

            
            for (int i=0;i<a;i++) 
            {
                for (int j=0;j<a; j++) 
                {
                    rotated180[a-1-i][a-1-j] = arr[i][j];
                }
            }

            
            for (int i=0;i<a;i++) 
            {
                for (int j=0;j<a;j++) 
                {
                    rotated270[a-1-j][i] =arr[i][j];
                }
            }

           
            sb.append("#"+ t).append("\n");
            for (int i=0; i<a; i++) {
                
                for (int j= 0; j < a; j++) {
                    sb.append(rotated90[i][j]);
                }
                sb.append(" ");
           
                for (int j = 0; j < a; j++) {
                    sb.append(rotated180[i][j]);
                }
                sb.append(" ");
                
                for (int j = 0; j < a; j++) {
                    sb.append(rotated270[i][j]);
                }
                sb.append("\n");
            }
        }
		System.out.println(sb);
	}
}