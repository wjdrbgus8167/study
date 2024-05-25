import java.io.*;
import java.util.*;


class Main 
{
	
	static boolean visited[];
	static int arr[][];
	static int m;
	static int n;
	static Queue<Integer> que = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
   public static void main(String[] args)throws IOException{
	   
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  
	  StringTokenizer st = new StringTokenizer(br.readLine());
	  
	  
	  n = Integer.parseInt(st.nextToken());
	  m = Integer.parseInt(st.nextToken());
	  int v = Integer.parseInt(st.nextToken());
	  
	  arr = new int[n+1][n+1];
	  visited = new boolean[n+1];
	  
	  for(int i=0;i<m;i++)
	  {
		 st = new StringTokenizer(br.readLine());
		 
		int a =Integer.parseInt(st.nextToken()); 
		int b =Integer.parseInt(st.nextToken());
		arr[a][b]=arr[b][a] = 1;
	  }
			 
	  dfs(v,0);
	  sb.append("\n");
	  visited = new boolean[n+1];
	 
	  que.offer(v);
	  visited[v] =true;
	  bfs();
	  
	  System.out.println(sb);
   }
   public static void dfs(int x,int depth)
   {
	   
	   visited[x] = true;
	   sb.append(x).append(" ");
	   if(depth==m)
	   {
		   
		   return;
	   }
	  
	   for(int i=1;i<=n;i++)
	   {
		   if(arr[x][i]==1&&!visited[i])
		   {
			   
			   dfs(i,depth+1);
		   }
	   }
   }
   
   public static void bfs()
   {
	   while(!que.isEmpty())
	   {
		   int x=que.poll();
		   
		   sb.append(x).append(" ");
		 
		   for(int i=1;i<=n;i++)
		   {
			   if(arr[x][i]==1&&!visited[i])
			   {		   
				   que.offer(i);
				   visited[i] = true;
			   }
		   }
		   bfs();
	   
	   }
	  
   }
}