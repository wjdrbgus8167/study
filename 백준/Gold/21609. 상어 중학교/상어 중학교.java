import java.io.*;
import java.util.*;

class Block{

    int x,y;

    public Block(int x,int y){
        this.x = x;
        this.y = y;

    }
}
class Group{
    ArrayList<Block> group = new ArrayList<>();
    int color;
    int rainbow;
    int standard_x =-1, standard_y =-1;

    int size(){
        return group.size();
    }

}
class Main{

    final static int EMPTY = -2;
    final static int BLACK = -1;
    final static int RAINBOW = 0;
    static int N,M;
    static int[][] map;
    static long score = 0;

    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){

                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 오토플레이

        while(true){
            Group best = null;

            // 모든 일반색 칸에서 그룹 탐색

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){

                    if(map[i][j] >=1){
                        Group g = make_group(i,j);
                        if(g ==null) continue;
                        if(best == null || checking_group(g,best)<0) best = g;
                    }
                }
            }

            if(best == null) break;

            remove_group(best);
            gravity();
            rotate_reverse_circle();
            gravity();
        }

        System.out.println(score);

    }

    public static Group make_group(int x,int y){

        int color = map[x][y];

        if(color <=0) return null;

        boolean[][] visited = new boolean[N][N];
        Group g = new Group();
        g.color = color;

        dfs(x,y,color,visited,g);

        if(g.size()<2) return null;

        return g;

    }
    public static void dfs(int x,int y,int color,boolean[][] visited,Group g){

        // 방문 처리
        visited[x][y] = true;
        g.group.add(new Block(x,y));

        //만약 무지개 색깔이면
        if(map[x][y] == RAINBOW){
            g.rainbow++;
        }else{

            // 기준 블록 후보로 등록
            if(g.standard_x==-1|| x<g.standard_x||(x==g.standard_x&&y<g.standard_y)){
                g.standard_x =x;
                g.standard_y = y;

            }
        }

        for(int i=0;i<4;i++){

            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||nx>=N||ny<0||ny>=N) continue;

            if(visited[nx][ny]) continue;

            if(map[nx][ny]==BLACK||map[nx][ny]== EMPTY) continue;

            if(map[nx][ny] == RAINBOW || map[nx][ny] == color){
                dfs(nx,ny, color,visited,g);
            }
        }

    }


    public static int checking_group(Group a, Group b) {

        if (a.size()!= b.size()) return b.size()- a.size();

        if (a.rainbow!= b.rainbow) return b.rainbow- a.rainbow;

        if (a.standard_x!= b.standard_x)return b.standard_x- a.standard_x;

        return b.standard_y - a.standard_y;
    }

    // 중력함수
    public static void gravity(){

        for(int i=0;i<N;i++){

            int length = N-1;

            for(int j=N-1;j>=0;j--){

                if(map[j][i]==BLACK){
                    length = j-1;
                }else if(map[j][i]!=EMPTY){
                    int v = map[j][i];
                    map[j][i] = EMPTY;

                    if(length>=0) {
                        map[length--][i] = v;
                    }
                }
            }

        }


    }

    //반시계 회전 함수
    public static void rotate_reverse_circle(){

        int[][] result = new int[N][N];

        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){

                result[N-1-j][i] = map[i][j];
            }
        }

        map = result;


    }

    public static void remove_group(Group g){

        for(Block b : g.group){
            map[b.x][b.y] = EMPTY;
        }

        int size = g.size();
        score +=(long)Math.pow(size,2);
    }
}