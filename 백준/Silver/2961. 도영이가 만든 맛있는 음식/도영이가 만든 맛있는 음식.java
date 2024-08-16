

import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int cook[][];
	static int result;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		// 재료 신맛, 쓴맛 저장
		cook = new int[N][2];
		for(int i=0;i<N;i++) {
			
			st = new StringTokenizer(br.readLine());
			cook[i][0] =Integer.parseInt(st.nextToken());
			cook[i][1] = Integer.parseInt(st.nextToken());
		}
		// 결과값 
		result=Integer.MAX_VALUE;
		// 신맛-쓴맛 최소 값 찾기 
		cooking(0,1,0,0);
		
		System.out.println(result);
	}
	
	public static void cooking(int cnt,int S_sum,int B_sum,int depth) {
		// cnt = 최소 1개 이상 선택하기 
		// S_sum = 신맛 총합, B_sum = 쓴맛 총합 
		
		
		if(depth==N)
		{
			if(cnt>=1)
			{
				// 최소값 갱신 
				result = Math.min(result, Math.abs(S_sum-B_sum));
				return;
			}
			
			return ;
		}
		cooking(cnt+1,S_sum*(cook[depth][0]),B_sum+(cook[depth][1]),depth+1);
		
		cooking(cnt,S_sum,B_sum,depth+1);
		
		
	}
	

}