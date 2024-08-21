import java.io.*;
import java.util.*;

public class Main {

	static int count;
	static int r,c;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size= (int)Math.pow(2, N)/2;
		count=0;
		visitcheck(size,size,size);
		
		System.out.println(count);
	}

	public static void visitcheck(int size_r,int size_c,int size) {
		
		if(size<=0) {
			return ;
		}
		if(r<size_r && c<size_c) {
			
			visitcheck(size_r-(size/2),size_c-(size/2),size/2);
			
		}else if(r<size_r && c>=size_c) {
			
			count += (size*size);
			visitcheck(size_r-(size/2),size_c+(size/2),size/2);
			
		}else if(r>=size_r && c<size_c) {
			
			count += ((size*size))*2;
			visitcheck(size_r+(size/2),size_c-(size/2),size/2);
		}else {
			count+= ((size*size))*3;
			visitcheck(size_r+(size/2),size_c+(size/2),size/2);
		}
		
	}
}
