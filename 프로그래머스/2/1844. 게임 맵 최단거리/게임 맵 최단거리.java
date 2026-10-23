import java.util.*;

class Solution {
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        // 현재 내 위치 인덱스 -> 0,0
        // 상대팀 진영 위치 인덱스 0> 4,4
        
        
        answer = bfs(0,0,maps);
        
        return answer;
    }
    
    public static int bfs(int start_x,int start_y,int[][] maps){
        
        Queue<int[]> que = new ArrayDeque<>();
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        que.add(new int[]{0,0,1});
        visited[0][0] =true;
        
        while(que.size()>0){
            
            int size = que.size();
            
            for(int i=0;i<size;i++){
                
                int[] info = que.poll();
                int x = info[0];
                int y = info[1];
                int depth = info[2];
                
                if(x==n-1&&y==m-1) return depth;
                
                for(int j=0;j<4;j++){
                    
                    int nx = dx[j]+x;
                    int ny = dy[j]+y;
                    
                    if(nx<0||nx>=n||ny<0||ny>=m) continue;
                    if(visited[nx][ny]) continue;
                    if(maps[nx][ny]==0) continue;
                    
                    visited[nx][ny]=true;
                    que.add(new int[]{nx,ny,depth+1});
                }
            }
        }
        
        
        
        return -1;
    }
}