import java.io.*;
import java.util.*;

public class Main{

	static int R,C;
	static boolean visited[][];
	static char map[][];
	static int dx[] = {-1,0,1};
	static int dy[]= {1,1,1};
	static int max_cnt;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		R =Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		max_cnt=0;
		for(int i=0;i<R;i++) {
			if(pipeline(i,0)) {
				max_cnt++;
			}
		}
		
		System.out.println(max_cnt);
	}

	public static boolean pipeline(int x,int y) {
		
		if(y==C-1) {
			
			return true;
		}
		
		// 위로 보낸다 -> 안보
		for(int i=0;i<3;i++) {
			
			int next_x = dx[i]+x;
			int next_y = dy[i]+y;	

			if(next_x>=0&&next_x<R&&next_y>=0&&next_y<C) {
				if(!visited[next_x][next_y]&&map[next_x][next_y]=='.') {
					
					visited[next_x][next_y]=true;
					
					if(pipeline(next_x,next_y)) {
						return true;
					}
				}
				
				
			}
			
			
		}
		
		return false;
			
		
		
	}
}
