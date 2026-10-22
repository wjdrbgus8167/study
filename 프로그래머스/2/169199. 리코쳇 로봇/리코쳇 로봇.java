import java.util.*;

class Solution {
    
    static int[] dx= {1,0,0,-1};
    static int[] dy = {0,1,-1,0};
    static int N;
    static int M;
    public int solution(String[] board) {
        int answer = 0;
        
        N = board.length;
        M = board[0].length();
       
        Character[][] map = new Character[N][M];
        
        int start_x = 0;
        int start_y = 0;
        
        // 맵 채우고 시작 위치 찾기
        for(int i=0;i<N;i++){
            
            String s = board[i];
            
            for(int j=0;j<M;j++){
                
                Character c= board[i].charAt(j);
                map[i][j] = c;
                
                if(c=='R'){
                    start_x = i;
                    start_y =j;
                }
            }
        }
        
        answer= bfs(start_x,start_y,map);
        
        
        
        return answer;
    }
    
    public static int bfs(int start_x,int start_y, Character[][]map){
        
        boolean[][] visited = new boolean[N][M];
        
        Queue<int[]> que = new ArrayDeque<>();
        
        // x,y,depth, 방향
        que.add(new int[]{start_x,start_y,0});
        visited[start_x][start_y]=true;
        
        while(que.size()>0){
            int size = que.size();
            
            for(int i=0;i<size;i++){
                
                int[] d = que.poll();
                int x = d[0];
                int y = d[1];
                int depth = d[2];
                
                if(map[x][y]=='G') return depth;
                
                for(int j=0;j<4;j++){
                    
                    int nx = x;
                    int ny = y;
                
                    
                    while(true){
                        
                        nx +=dx[j];
                        ny +=dy[j];    
                        
                        if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]=='D'){
                           nx-=dx[j];
                           ny-=dy[j];
                           break;
                        } 
                    
                        
                    }
                   
                    if (visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny, depth + 1});          
                    
                }
            }
            
        }
        
        return -1;
    }
}