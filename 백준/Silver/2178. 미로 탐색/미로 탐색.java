import java.io.*;
import java.util.*;

class Point{
    int x,y,day;

    public Point(int x,int y,int day){
        this.x = x;
        this.y = y;
        this.day = day;
    }
}
public class Main{

    static int N,M;
    static int min;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};


    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        min = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j)-48;
            }
        }

        bfs();
        System.out.println(min);
    }

    public static void bfs(){
        Queue<Point> que = new ArrayDeque<>();

        que.add(new Point(0,0,1));

        visited[0][0] =true;

        while(!que.isEmpty()){

            Point p = que.poll();

            if(p.x==N-1&&p.y==M-1){
                min = Math.min(min,p.day);
                return ;
            }


            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0||ny<0||nx>=N||ny>=M) continue ;

                if(!visited[nx][ny]&&map[nx][ny]==1){
                    visited[nx][ny]=true;
                    que.add(new Point(nx,ny,p.day+1));
                }
            }


        }

    }

}