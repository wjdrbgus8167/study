import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int dx[]= {0,1};
	static int dy[]= {1,0};
	static int arr[][];
	static boolean [][] visited;
	static int n;
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0;i<n;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<n;j++)
			{
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
			System.out.println("Hing");
		
	}
	public static void dfs(int i,int j)
	{
		if(arr[i][j]==-1)
		{
			System.out.println("HaruHaru");
			System.exit(0);
		}
		
		for (int k = 0; k < 2; k++) {
			int x = i + dx[k] * arr[i][j];
			int y = j + dy[k] * arr[i][j];
			
			if(x>=n || y>=n || visited[x][y]) continue;
			
			visited[x][y] = true;
			dfs(x, y);
		}

		
	}
}