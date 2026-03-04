import java.util.*;

class Solution {
    
    private List<Integer>[] graph;
    private boolean[] visited;
    private int n;
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];
        
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] w : wires){
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        
        
        for(int[] w : wires){
            
            graph[w[0]].remove(Integer.valueOf(w[1]));
            graph[w[1]].remove(Integer.valueOf(w[0]));
            
            visited = new boolean[n+1];
            int size = dfs(1);
            
            int diff = Math.abs(n-2*size);
            answer = Math.min(answer,diff);
            
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        
        return answer;
    }
    
    private int dfs(int node){
        visited[node] = true;
        int cnt = 1;
        
        for(int next : graph[node]){
            if(!visited[next]){
                cnt+=dfs(next);
            }
        }
        
        return cnt;
    }
}