import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	
	static int arr[][];
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int Cnt = Integer.parseInt(st.nextToken());
	
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int k=0;k<Cnt;k++) {
			for(int i=0;i<Math.min(N, M)/2;i++) {
				rotation(i,i);
			}	
		}
		for(int i=0;i<N;i++) {
		
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
			
	}
	public static void rotation(int x,int y) {
		int temp = arr[x][y];
		
	
		for(int j=y;j<M-y-1;j++) {
			arr[x][j] = arr[x][j+1];
		}
		
		
		for(int j=y;j<N-y-1;j++) {
			arr[j][M-1-x] = arr[j+1][M-1-x];
		}
		
		
		for(int j=M-y-1;j>y;j--) {
			arr[N-1-x][j] = arr[N-1-x][j-1];
		}
		
		
		for(int j=N-y-1;j>y;j--) {
			arr[j][x] = arr[j-1][x];
		}
		
		arr[y+1][x]=temp;
		
	}

}
