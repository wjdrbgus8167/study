import java.io.*;
import java.util.*;


/*

 */

class Point{

    int x,y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Main{

    static int N,L,R;

    static int[][] country;
    static boolean[][] visited;
    static boolean possible;
    static int move_day=0;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        country = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){
                country[i][j] = Integer.parseInt(st.nextToken());

            }
        }


        while(true){
            visited = new boolean[N][N];
            possible = false;

            for(int i=0;i<N;i++){

                for(int j=0;j<N;j++){

                    if(!visited[i][j]){
                        List<Point> union = new ArrayList<>();
                        int sum = bfs(i,j,union);

                        if(union.size()>1){
                            possible = true;
                            int avg = sum/union.size();
                            for(Point p:union) country[p.x][p.y]=avg;
                        }
                    }

                }
            }
            if (!possible) break;
            move_day++;

        }



        System.out.println(move_day);


    }

    public static int bfs(int x, int y,List<Point> union){

        ArrayDeque<Point> dq = new ArrayDeque<>();

        dq.add(new Point(x,y));
        union.add(new Point(x,y));
        visited[x][y] = true;

        int sum = country[x][y];

        while(!dq.isEmpty()){

            Point p = dq.poll();

            for(int i=0;i<4;i++){

                int nx = dx[i]+p.x;
                int ny = dy[i]+p.y;

                if(bound_check(nx,ny)) continue;

                int difference = Math.abs(country[p.x][p.y]-country[nx][ny]);

                if(!visited[nx][ny]&&(L<=difference&&difference<=R)){
                    visited[nx][ny] = true;
                    union.add(new Point(nx,ny));
                    sum +=country[nx][ny];
                    dq.add(new Point(nx,ny));
                }

            }
        }

        return sum;


    }


    public static boolean bound_check(int x,int y){

        return x<0||x>=N||y<0||y>=N;
    }
}