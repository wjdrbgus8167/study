import java.util.*;


class Solution {
    
    static boolean[] visited;
    static int n;
    static int[][] computers;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        this.computers = computers;
        
        visited = new boolean[n];
        
        
        for(int i=0;i<n;i++){
            
            if(visited[i]) continue;
            bfs(i);
            answer++;
            
        }
        
        
        return answer;
    }
    
    
    public static void bfs(int x){
        Queue<Integer> que = new ArrayDeque<>();
        
        que.add(x);
        visited[x] = true;
        
        
        while(!que.isEmpty()){
            int size = que.size();
            
            for(int i=0;i<size;i++){
                
                int node = que.poll();
                
                for(int j=0;j<n;j++){
            
                    if(j==node||computers[node][j]==0) continue;
                    if(visited[j]) continue;
                    
                    visited[j] = true;
                    que.add(j);
                }
            }
            
        }
        
        
        
        
    }
}