import java.io.*;
import java.util.*;


class Fish{

    int num,direction,fish_x,fish_y;

    public Fish(int num, int direction,int fish_x,int fish_y){
        this.num = num;
        this.direction = direction;
        this.fish_x = fish_x;
        this.fish_y = fish_y;
    }
}

class Main{

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int result ;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int[][] map = new int[4][4];
        Fish[] fish_state = new Fish[17];
        boolean[] visited = new boolean[17];
        //int result = 0;

        for(int i=0;i<4;i++){

            st = new StringTokenizer(br.readLine());

            for(int j=0;j<4;j++){

                int fish_num = Integer.parseInt(st.nextToken());
                int fish_direction = Integer.parseInt(st.nextToken())-1;

                map[i][j] = fish_num;
                fish_state[fish_num] =new Fish(fish_num,fish_direction,i,j);

            }
        }

        int first_shark_direction = fish_state[map[0][0]].direction;

        int first_shark_sum = map[0][0];
        visited[map[0][0]]=true;
        map[0][0]=0;
        result =0;
        
        result = shark_move(0,0,first_shark_sum,first_shark_direction,map,fish_state,visited);

        System.out.println(result);
    }

    public static int shark_move(int x,int y, int sum, int direction,int[][] map,Fish[] fish_state,boolean[] visited){
        
        int[][] copy_map = copy_map(map);
        Fish[] copy_fish_state = copy_fish_state(fish_state);
        boolean[] copy_visited = copy_visited(visited);

        fish_move(x,y,copy_map,copy_fish_state,copy_visited);

        int best= sum;
        int nx = x;
        int ny = y;

        for (int i=1;i<= 3;i++) {

            nx += dx[direction];
            ny += dy[direction];

            if (bound_checking(nx, ny)) break;
            if (copy_map[nx][ny] == 0) continue;


            int[][] bMap = copy_map(copy_map);
            Fish[] bFish = copy_fish_state(copy_fish_state);
            boolean[] bVisited = copy_visited(copy_visited);

            int fishNum = bMap[nx][ny];          
            int nextDir = bFish[fishNum].direction;

            bVisited[fishNum] = true;            
            bMap[nx][ny] = 0;                    


            best = Math.max(best,shark_move(nx, ny, sum + fishNum, nextDir, bMap, bFish, bVisited));
        }

        return best;
    }

    public static void fish_move(int shark_x,int shark_y,int[][] map,Fish[] fish_state,boolean[] visited){

        for(int i=1;i<=16;i++){

            if(visited[i]) continue;

            int dir = fish_state[i].direction;
            int fish_x = fish_state[i].fish_x;
            int fish_y = fish_state[i].fish_y;

            int cnt =0;

            while(true){

                if(cnt == 8){
                    break;
                }

                int nx = fish_x + dx[dir];
                int ny = fish_y + dy[dir];

                if(bound_checking(nx,ny)||(nx==shark_x&&ny==shark_y)){
                    dir = (dir+1)%8;
                    cnt++;
                }else if(map[nx][ny]==0){
                    fish_state[i] = new Fish(i,dir,nx,ny);
                    map[nx][ny] = i;
                    map[fish_x][fish_y] =0;
                    break;
                } else{
                    fish_state[i] = new Fish(i,dir,nx,ny);
                    fish_state[map[nx][ny]] =new Fish(map[nx][ny],fish_state[map[nx][ny]].direction,fish_x,fish_y);
                    map[fish_x][fish_y] = map[nx][ny];
                    map[nx][ny] = i;
                    break;
                };
            }
        }
    }

    public static boolean bound_checking(int x,int y){

        return x<0||x>=4||y<0||y>=4;
    }

    public static int[][] copy_map(int[][] map){

        int[][] copy_map= new int[4][4];

        for(int i=0;i<4;i++){

            for(int j=0;j<4;j++){

                copy_map[i][j] = map[i][j];
            }
        }

        return copy_map;
    }

    public static boolean[] copy_visited(boolean[] visited){

        boolean[] copy_visited = new boolean[17];

        for(int i=1;i<=16;i++){

            copy_visited[i] = visited[i];
        }

        return copy_visited;
    }

    public static Fish[] copy_fish_state(Fish[] fish_state) {
        Fish[] c = new Fish[17];
        for (int i = 1; i <= 16; i++) {
            if (fish_state[i] != null) {
                Fish f = fish_state[i];
                c[i] = new Fish(f.num, f.direction, f.fish_x, f.fish_y);
            }
        }
        return c;
    }
}

