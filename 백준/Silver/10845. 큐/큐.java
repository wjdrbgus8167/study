

import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> que =new ArrayDeque<>();
		
		for(int i=0;i<t;i++) {
			
			st = new StringTokenizer(br.readLine());
			String comm = st.nextToken();
			
			switch(comm) {
			
			case "push":{
				int n = Integer.parseInt(st.nextToken());
				que.add(n);
				break;
			}
			case "pop":{
				if(que.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(que.poll()).append("\n");
				}
				break;
			}
			case "size":{
				sb.append(que.size()).append("\n");
				break;
			}
			case "empty":{
				if(que.isEmpty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
				break;
			}
			case "front":{
				if(que.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(que.peekFirst()).append("\n");
				}
				break;
			}
			case "back":{
				if(que.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(que.peekLast()).append("\n");
				}
				break;
			}
			
				
			}
		}
		
		System.out.println(sb);
				
	}

}
