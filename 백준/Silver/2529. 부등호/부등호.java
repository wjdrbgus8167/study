import java.util.*;
import java.io.*;
public class Main {

	static int k;
	
	static boolean visited[];
	static int seq_num[];
	static StringBuilder sb = new StringBuilder();
	static String calculate[];
	static ArrayDeque<String> que = new ArrayDeque<>();
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 값
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 부등호 저장 배열
		calculate = new String[k];
		
		for(int i=0;i<k;i++)
		{
			calculate[i] =st.nextToken();
		}
		// N개 중 M개 뽑고 저장할 배열
		seq_num = new int[k+1];
		// 중복 여부 확인
		visited = new boolean[10];
		sequence(0);
		System.out.println(que.getLast());
		System.out.println(que.poll());
	}
	public static void sequence(int cnt)
	{
		// k+1만큼 cnt 충족 -> 뽑기 끝
		if(cnt==k+1)
		{
			
			sb = new StringBuilder();
			// depth가 K번 만족하면 통과
			//int depth=0;
			for(int i=0;i<k;i++)
			{
				if(calculate[i].equals(">"))
				{
					if(seq_num[i]>seq_num[i+1])
					{
						continue;
					}else {
						return;
					}
				}else if(calculate[i].equals("<")) {
					if(seq_num[i]<seq_num[i+1])
					{
						continue;
					}else {
						return;
					}
				}
			}
			
				for(int num :seq_num)
				{
					sb.append(num);
				}
				
				que.add(sb.toString());
			
			return;
		}
		// N개의 숫자 탐색
		for(int i=0;i<=9;i++)
		{
			//중복 x면 
			if(!visited[i])
			{
				seq_num[cnt]=i;
				visited[i] = true;
				sequence(cnt+1);
				// 백트래킹
				visited[i] =false;
			}
		}
	}

}
