import java.io.*;
import java.util.*;
 
public class Solution {
   
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testcase=1;testcase<=t;testcase++)
		{
			int k  = Integer.parseInt(br.readLine());
			int N = (int)Math.pow(2,k)-1;
			sb.append("#"+testcase+" ");
			int[] node = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				node[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] tree = new int[N+1];
			
			dfs(0,N-1,1,0,tree,node);
			
			int i=1;
			int n=0;
			
			for(int level=0;level<k;level++)
			{
				n +=(int)Math.pow(2,level);
				
				for(;i<=n;i++) {
					sb.append(tree[i]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb);
		
    }
	
	public static void dfs(int left,int right, int treeIndex,int nodeIndex,int tree[],int node[])
	{
		int root =(left + right)/2;
		tree[treeIndex] = node[root];
		
		if(left==right)
			return;
		dfs(left,root-1,treeIndex*2,root,tree,node);
		dfs(root+1,right,treeIndex*2+1,root,tree,node);
	}
  
}