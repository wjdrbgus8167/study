import java.io.*;
import java.util.*;


class Main {
	
	static int w;
	static int h;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = {1,-1,0,0,1,1,-1,-1};
	static int dy[] = {0,0,1,-1,1,-1,1,-1};
	
    public static void main(String[] args)throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    
    while(true)
    {
    
    	st = new StringTokenizer(br.readLine());
    	w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        if(w==0&&h==0)
        {
        	break;
        }
        arr = new int[h][w];
        visited = new boolean[h][w];
        
        for(int i=0;i<h;i++)
        {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<w;j++)
        	{
        		arr[i][j]=Integer.parseInt(st.nextToken());;
        	}
        }
        int count=0;
        for(int i=0;i<h;i++)
        {
        	for(int j=0;j<w;j++)
        	{
        		if(arr[i][j]==1&&!visited[i][j])
        		{
        			
        			visited[i][j]=true;
        			dfs(i,j);
        			count++;
        		}
        	}
        }
        sb.append(count).append("\n");
    }
    System.out.println(sb);
    
    
    
    }
    public static void dfs(int h1,int w1)
    {
    	
    	for(int i=0;i<8;i++)
    	{
    		int x = dx[i]+h1;
    		int y = dy[i]+w1;
    		
    		if(x>=0&&y>=0&&x<h&&y<w)
    		{
    			if(arr[x][y]==1&&!visited[x][y])
    			{
    				
    				visited[x][y]=true;
    				dfs(x,y);
    			}
    		}
    	}
    }
}
