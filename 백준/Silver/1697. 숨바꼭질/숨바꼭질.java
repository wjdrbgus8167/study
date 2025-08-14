import java.io.*;
import java.util.*;


class Point{

    int point, day;

    public Point(int point,int day){
        this.point = point;
        this.day = day;
    }
}
class Main{

    static int N,K;
    static int min_day;
    static int Max =200000;
    static boolean[] visited;

    public static void main(String[] args)throws IOException{

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[Max+1];
        min_day = 0;

        if(N>=K){
            System.out.println(N-K);
        }else{
            bfs();
            System.out.println(min_day);
        }

    }

    public static void bfs(){

        ArrayDeque<Point> que = new ArrayDeque<>();

        que.add(new Point(N,0));
        visited[N] = true;

        while(!que.isEmpty()){

            Point p = que.poll();

            int day = p.day;
            int point = p.point;

            if(point == K){

                min_day =p.day;
                return ;
            }

            int dx[] = {point-1,point+1,point*2};

            for(int i=0;i<3;i++){

                if(0<=dx[i]&&dx[i]<=Max&&!visited[dx[i]]){
                    visited[dx[i]] = true;
                    que.add(new Point(dx[i],day+1));
                }
            }

        }

    }
}