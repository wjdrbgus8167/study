import java.io.*;
import java.util.*;


class Main {
	
	static int n;
	static List<Integer>[] list;
	static boolean visited[];
	static int[] parents;
	
	
    public static void main(String[] args)throws IOException{
    
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Integer.parseInt(br.readLine());
    	list = new ArrayList[n+1];
    	visited = new boolean[n+1];
    	parents = new int[n+1];
    	
    	for(int i=0;i<n+1;i++)
    	{
    		list[i] = new ArrayList<>();
    	}
    	StringTokenizer st ;
    	for(int i=0;i<n-1;i++)
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		int a = Integer.parseInt(st.nextToken());
    		int b=  Integer.parseInt(st.nextToken());
    		
    		list[a].add(b);
    		list[b].add(a);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	dfs(1);
    	
    	for(int i=2;i<parents.length;i++)
    	{
    		sb.append(parents[i]).append("\n");
    	}
    	System.out.println(sb);
    }
    public static void dfs(int x) {
    	
    	visited[x] = true;
    	
    	for(int i:list[x])
    	{
    		if(!visited[i])
    		{
    			parents[i]=x;
    			dfs(i);
    		}
    	}
    }
}
