import java.io.*;
import java.util.*;

public class Main{

	static int arr[][];
	static int N;
	static StringBuilder sb;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {	
				arr[i][j] = s.charAt(j)-48;
			}
		}
		
		sb = new StringBuilder();
		
		compress(0,0,N);
		
		System.out.println(sb);
	}

	public static void compress(int x, int y,int size) {
		
		int sum=0;
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				sum +=arr[i][j];
			}
		}
		
		if(sum==0) {
			
			sb.append("0");
			
		}else if(sum==size*size) {
			
			sb.append("1");
			
		}else {
			int half = size/2;
			sb.append("(");
			compress(x,y,half);
			compress(x,y+half,half);
			compress(x+half,y,half);
			compress(x+half,y+half,half);
			sb.append(")");
		}
		
		
	}
}
