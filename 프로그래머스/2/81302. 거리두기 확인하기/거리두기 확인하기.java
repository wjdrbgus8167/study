import java.util.*;

class Solution {
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] map;
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[5];
        
        
        for(int i=0;i<5;i++){
            
            map = new char[5][5];
            List<int[]> list = new ArrayList<>();    
            
            for(int j=0;j<5;j++){
                String s = places[i][j];
                
                for(int k=0;k<5;k++){
                    map[j][k]  = s.charAt(k);
                    
                    if(map[j][k]=='P') list.add(new int[]{j,k});
                }
            }
            
            
            boolean ok = true;
            for(int[] a : list){
                        
                if(!bfs(a[0],a[1])){
                    ok =false;
                    break;
                }
            }
            
           answer[i] = ok ? 1 : 0;
            
            
        }
        return answer;
    
    }
    
    static boolean bfs(int x,int y){
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        boolean[][] visited=  new boolean[5][5];
        
        que.add(new int[]{x,y,0});
        visited[x][y] = true;
        
        while(!que.isEmpty()){
            
            int[] a = que.poll();
            int sn = a[0];
            int sy = a[1];
            int depth = a[2];
            
    
            if(depth==2) continue;
            
            for(int j = 0;j<4;j++){
                
                int nx = dx[j] + sn;
                int ny = dy[j] + sy;
                
                if(inRange(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                
                if(map[nx][ny]=='X') continue;
                
                if(map[nx][ny]=='P') return false;
            
                
                visited[nx][ny] =true;
                que.add(new int[]{nx,ny,depth+1});
                
            }
        }
        return true;
    }
    
    static boolean inRange(int x,int y){
        return x<0||y<0||x>=5||y>=5;
    }
}