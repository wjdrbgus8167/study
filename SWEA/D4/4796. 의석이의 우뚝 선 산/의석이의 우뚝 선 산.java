import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int mountain[];
	static int sum;
	static ArrayList<Integer> list;
	public static void main(String[] args)throws IOException {
		
		Scanner sc  = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t= sc.nextInt();
		
		for(int tc=1;tc<=t;tc++) {
			
			N = sc.nextInt();
			
			mountain = new int[N];
			for(int i=0;i<N;i++) {
				mountain[i]= sc.nextInt();	
			}
			list = new ArrayList<>();
			for(int i=1;i<N-1;i++) {
				
				if(mountain[i]>mountain[i-1]&&mountain[i]>mountain[i+1]) {
					list.add(i);
				}
			}
			sum =0;
			
			for(int a:list) {
				
				check(a);
			}
			
			
			sb.append("#"+tc+" "+sum).append("\n");
		}
		System.out.println(sb);
	}
	public static void check(int idx) {
		
		int origin =idx;
		int left_cnt =0;
		int right_count =0;
		
		while(true) {
			
			if(idx==0) {
				break;
			}
			if(mountain[idx]>mountain[idx-1]) {
				left_cnt++;
				idx--;
			}else {
				break;
			}
			
			
			
		}
		
		while(true) {
			
			if(origin>=N-1) {
				break;
			}
			if(mountain[origin]>mountain[origin+1]) {
				right_count++;
				origin++;
			}else {
				break;
			}
			
			
		}
		
		
		sum += left_cnt*right_count;
		return;
			
	}

}
