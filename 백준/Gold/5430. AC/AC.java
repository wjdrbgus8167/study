


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		// AC : 정수 배열에 연산을 하기 위해 만든 언어 
		// 이 언어에는 두 가지 함수 R:뒤집기, D : 버리기가 존재 
		// 함수 R은 배열에 있는 수의 순서를 뒤집는 함수, D는 첫 번째 수를 버리는 함수 
		// 배열이 비어있는데 D를 사용한 경우에는 에러가 발생 
		// 함수는 조합해서 한 번에 사용할 수 있다. 
		// ex) "AB"는 A를 수행 후 B를 수행 
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=t;i++) {
			String command = br.readLine();
			
			int n = Integer.parseInt(br.readLine());
			
			String number = br.readLine();
			
			ArrayDeque<Integer> que = new ArrayDeque<>();
			boolean state = false;
			boolean error = false;
			Pattern pattern = Pattern.compile("\\d+");
	        Matcher matcher = pattern.matcher(number);
			
	        while(matcher.find()) {
	        	que.add(Integer.parseInt(matcher.group()));
	        }
			
	        for(int j=0;j<command.length();j++) {
	        	
	        	
	        	if(command.charAt(j)=='R') {
	        		state=!state;
	        	}else {
	        		if(que.isEmpty()) {
	        			error= true;
	        			break;
	        		}else {
	        			if(!state) {
		        			que.pollFirst();
		        		}else {
		        			que.pollLast();
		        		}
	        		}
	        		
	        	}
	        }
			
	        if(que.size()!=0) {
	        	
	        	sb.append("[");
	        	if(!state) {
	        	   
	        		int size = que.size();
	 	    	   
	        		for(int k=0;k<size;k++) {
	 	    		   if(k==size-1) {
	 	    			  sb.append(que.pollFirst());
	 	    		   }else {
	 	    			  sb.append(que.pollFirst()+",");
	 	    		   }
	 	    		   
	 	    	   }
	 	    	   sb.append("]").append("\n");
	        		
	 	       	}else {
	 	       		
	 	       		int size= que.size();
	 	       	for(int k=0;k<size;k++) {
	 	    		   if(k==size-1) {
	 	    			  sb.append(que.pollLast());
	 	    		   }else {
	 	    			  sb.append(que.pollLast()+",");
	 	    		   }
	 	    		   
	 	    	   }
	 	    	   sb.append("]").append("\n");
	 	       	}
	        	
	        }else {
	        	if(error) {
	        		sb.append("error").append("\n");
		        	
	        	}else {
	        		sb.append("[]").append("\n");
		        	
	        	}
	        	
	        }
	       
		}
		
		
		System.out.println(sb);
	}

}