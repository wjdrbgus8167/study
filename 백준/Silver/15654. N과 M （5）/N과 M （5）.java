

import java.io.*;
import java.util.*;

public class Main{

	static int N,M;
	static boolean visited[];
	static int arr[];
	static int arr1[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		arr1 = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			
			arr[i] =Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		permutation(0);
		System.out.println(sb);
	}
	public static void permutation(int cnt) {
		if(cnt==M) {
			
			for(int i=0;i<M;i++) {
				sb.append(arr1[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			
			if(!visited[i]) {
				visited[i]=true;
				arr1[cnt]=arr[i];
				permutation(cnt+1);
				visited[i]=false;
				
			}
		}
	}

}
