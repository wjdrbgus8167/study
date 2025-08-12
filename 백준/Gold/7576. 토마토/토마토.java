import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.io.BufferedReader;

class Point{
    int x,y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;

    }

}
class Main{

    static int N,M;
    static int tomato[][];
    static boolean visited[][];
    static int tomato_cnt;
    static int min_day=0;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static ArrayDeque<Point> que;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        que = new ArrayDeque<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tomato = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0;i<M;i++){

            st= new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){

                tomato[i][j] = Integer.parseInt(st.nextToken());

                if(tomato[i][j]==1){
                    que.add(new Point(i,j));
                }else if(tomato[i][j]==0){

                    tomato_cnt++;
                }
            }

        }

        ripe();

        if(tomato_cnt!=0){
            System.out.println(-1);
        }else{
            System.out.println(min_day);
        }

    }
    public static void ripe(){

        while(!que.isEmpty()){

            int size= que.size();

            if(tomato_cnt==0){
                return ;
            }

            min_day++;

            for(int j=0;j<size;j++){
                Point p = que.poll();
                for(int i=0;i<4;i++){

                    int nx = dx[i]+p.x;
                    int ny = dy[i]+p.y;

                    if(nx<0||nx>=M||ny<0||ny>=N) continue;

                    if(tomato[nx][ny]==0){
                        tomato[nx][ny]=1;
                        que.add(new Point(nx,ny));
                        tomato_cnt--;
                    }


            }

            }

        }
    }
}