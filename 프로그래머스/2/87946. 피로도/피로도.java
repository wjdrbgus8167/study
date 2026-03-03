class Solution {
    
    private boolean[] visited;
    private int cnt=0;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        //["최소 필요 피로도","소모 피로도"]
        visited = new boolean[dungeons.length];
        
        dfs(k,dungeons,0);
        answer = cnt;
        
        return answer;
    }
    
    private int dfs(int fatigue,int[][] dungeons,int dun_cnt){
        
  
        cnt = Math.max(cnt,dun_cnt);
        
        for(int i=0;i<dungeons.length;i++){
            
            if(!visited[i]&&(fatigue>=dungeons[i][0])){
                visited[i] = true;
                dfs(fatigue-dungeons[i][1],dungeons,dun_cnt+1);
                visited[i] = false;
                
            }
        }
    
        return -1;
    }
    
}