import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		Stack<Integer> stack  =new Stack<>();
		
		for(int i=0;i<t;i++) {
			
			st = new StringTokenizer(br.readLine());
			String comm = st.nextToken();
			
			switch(comm) {
			
			case "push":{
				int n = Integer.parseInt(st.nextToken());
				stack.add(n);
				break;
			}
			case "pop":{
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(stack.pop()).append("\n");
				}
				break;
			}
			case "size":{
				sb.append(stack.size()).append("\n");
				break;
			}
			case "empty":{
				if(stack.isEmpty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
				break;
			}
			case "top":{
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(stack.peek()).append("\n");
				}
				break;
			}
			
				
			}
		}
		
		System.out.println(sb);
				
	}

}
