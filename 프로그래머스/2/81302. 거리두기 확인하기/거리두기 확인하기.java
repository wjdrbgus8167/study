import java.util.*;

class Solution {
    
    static int[] dx ={1,-1,0,0};
    static int[] dy= {0,0,-1,1};
    static StringBuilder sb = new StringBuilder();
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        List<int[]>list;
        Character[][] map ;
        
        for(int i=0;i<5;i++){
            list = new ArrayList<>();
            map = new Character[5][5];
            
            // 대기실 맵 생성 및 현재 사용자 위치 정보 저장 
            for(int j=0;j<5;j++){
                
                String s = places[i][j];
                
                for(int k=0;k<5;k++){
                    
                    map[j][k] = s.charAt(k);
                    
                    if(s.charAt(k) =='P') list.add(new int[]{j,k});      
            
                }
            }
            
            int cnt=list.size();
            boolean[][] visited;
            
            for(int j=0;j<list.size();j++){
                
                int x = list.get(j)[0];
                int y = list.get(j)[1];
            
                visited = new boolean[5][5];
                visited[x][y] =true;
                if(!dfs(x,y,0,map,visited)){
                   cnt--;
                } 
            }
            if(cnt!=list.size()){
                answer[i]=0;
            }else{
                answer[i]=1;
                
            }
            
        }
        
        return answer;
    }
    public static boolean dfs(int x,int y,int depth,Character[][] map,boolean[][] visited){
        
        if(depth>0&&map[x][y]=='P'){
            
            return false;
        }
        
        if(depth==2) return true;
        
        for(int i=0;i<4;i++){
            
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            if(nx<0||nx>=5||ny<0||ny>=5||visited[nx][ny]) continue;
            
            
            if(map[nx][ny]=='X') continue;
            
            
            
            visited[nx][ny] =true;
            
            if (!dfs(nx, ny, depth + 1, map, visited)) {
                    return false;
            }
        }
        
     
        return true;
    }
}