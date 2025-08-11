import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.*;

class Point{
    int x,y;

    public Point(int x,int y){
        this.x = x;
        this.y =y;
    }

}

public class Main{

    static int min_cnt=0;
    static int N,M;
    static int tomato[][];
    static int dx[] = {1,0,-1,0,};
    static int dy[] = {0,1,0,-1};
    static boolean visited[][];
    static int tomato_cnt=0;
    static ArrayList<Point> list;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tomato = new int[M][N];
        list = new ArrayList<>();
        visited = new boolean[M][N];


        for(int i=0;i<M;i++){

            st = new StringTokenizer(br.readLine());
            
            for(int j=0;j<N;j++){
                
                tomato[i][j] = Integer.parseInt(st.nextToken());
                
                if(tomato[i][j]==0){
                    tomato_cnt++;
                }else if(tomato[i][j]==1){

                    list.add(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }

        tomato_ripe();

        if(tomato_cnt==0){
            System.out.println(min_cnt);
        }else{
            System.out.println(-1);
        }

    }

    public static void tomato_ripe(){

       Queue<Point> que = new LinkedList<>();

       for(int i=0;i<list.size();i++){
           que.add(list.get(i));
       }


       while(!que.isEmpty()){

           int size = que.size();

           if(tomato_cnt==0){
               return ;
           }

           min_cnt++;

           for(int i=0;i<size;i++){
              
               Point p = que.poll();
              int x = p.x;
              int y = p.y;

               for(int j=0;j<4;j++){

                   int next_x = dx[j]+x;
                   int next_y = dy[j]+y;

                   if(bound_checking(next_x,next_y)&&!visited[next_x][next_y]){

                       if(tomato[next_x][next_y]==0){
                           
                           tomato_cnt--;
                           tomato[next_x][next_y]=1;
                           visited[next_x][next_y] =true;

                           Point point = new Point(next_x,next_y);
                           que.add(point);
                       }

                   }
               }

           }

       }
    }

    public static boolean bound_checking(int x,int y){

        return x>=0&&y>=0&&x<M&&y<N;
    }
}