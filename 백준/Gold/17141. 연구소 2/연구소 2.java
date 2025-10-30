import java.io.*;
import java.util.*;

class Point{

    int x,y;

    public  Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class Main{

    static int N,M;
    static int[][] map;
    static List<Point> possible_virus;
    static int spread_cnt = 0;

    static int min_time = Integer.MAX_VALUE;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N  = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        possible_virus = new ArrayList<>();

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){

                int a = Integer.parseInt(st.nextToken());

                if(a==2) {
                    possible_virus.add(new Point(i, j));
                    map[i][j] = 0;
                    spread_cnt++;
                }else if(a==0){
                    spread_cnt++;
                    map[i][j]=0;
                }else{
                    map[i][j] =a;
                }


            }
        }
        boolean[] combi = new boolean[possible_virus.size()];

        start(0,0,combi);

        if(min_time==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min_time);
        }

    }

    public static void start(int cnt,int a,boolean[] visited){


        if(cnt==M ){

            min_time = Math.min(min_time,spread(visited));
            return ;
        }

        for(int i=a;i<possible_virus.size();i++){
            visited[i]=true;
            start(cnt+1,i+1,visited);
            visited[i]=false;
        }

    }

    public static int spread(boolean[] list){

        boolean[][] visited=  new boolean[N][N];
        ArrayDeque<Point> dq = new ArrayDeque<>();

        int cnt =M;
        int time=-1;

        for(int i=0;i<list.length;i++){

            if(list[i]){
                Point p = possible_virus.get(i);
                visited[p.x][p.y] = true;
                dq.add(p);
            }

        }

        while(!dq.isEmpty()){

            int size = dq.size();
            time++;
            for(int i=0;i<size;i++){

                Point p = dq.poll();

                for(int j=0;j<4;j++){

                    int nx = dx[j] + p.x;
                    int ny = dy[j] + p.y;

                    if(check_bound(nx,ny)) continue;

                    if(!visited[nx][ny]&&map[nx][ny]==0){
                        visited[nx][ny] = true;
                        cnt++;
                        dq.add(new Point(nx,ny));
                    }

                }
            }


        }

        if(cnt==spread_cnt) {
            return time;
        }else {

            return Integer.MAX_VALUE;
        }



    }

    public static boolean check_bound(int x,int y){

        return x<0||x>=N||y<0||y>=N;
    }

}