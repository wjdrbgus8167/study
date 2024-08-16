

import java.io.*;
import java.util.*;

public class Main {

	
	static int minuse[] = new int[4];
	
	static int result ;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char password[] = new char[S];
		String s = br.readLine();
		for(int i=0;i<S;i++)
		{
			password[i] = s.charAt(i);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			minuse[i] = Integer.parseInt(st.nextToken());
		}
		result =0;
		
		int a=0;
		int b=0;
		int c=0;
		int d=0;
		ArrayDeque<Character> que = new ArrayDeque<>();
		for(int i=0;i<P;i++)
		{
			que.offer(password[i]);
			if(password[i]=='A')
			{
				a++;
			}else if(password[i]=='C')
			{
				b++;
			}else if(password[i]=='G')
			{
				c++;
			}else if(password[i]=='T'){
				d++;
			}
		}
		makingpassword(a,b,c,d);
		
		for(int i=P;i<S;i++) {
			char x = que.poll();
			
			if(x=='A') {
				a--;
			}else if(x=='C') {
				b--;
			}else if(x=='G') {
				c--;
			}else if(x=='T') {
				d--;
			}
			
			char y =password[i];
			
			if(y=='A') {
				a++;
			}else if(y=='C') {
				b++;
			}else if(y=='G') {
				c++;
			}else if(y=='T') {
				d++;
			}
			que.offer(y);
			makingpassword(a,b,c,d);	
		}
			
		System.out.println(result);
	}
	
	public static void makingpassword(int a,int b,int c,int d) {
		
		if(a>=minuse[0]&&b>=minuse[1]&&c>=minuse[2]&&d>=minuse[3])
		{
			result++;
		}
		
	}

}