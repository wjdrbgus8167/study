import java.io.*;
import java.util.*;

class Node{
    int x,y;

    public Node(int x,int y){

        this.x = x;
        this.y = y;
    }
}
class Main{

    static int N,M;
    static int[][] map;
    static ArrayList<Node> list ;
    static int cheeze_cnt;
    static boolean[][] visited;
    static boolean[] list_visited;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args)throws IOException{

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>();

        visited= new boolean[N][M];
        cheeze_cnt = 0;

        int time =0;

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());

            for(int j= 0;j<M;j++){
                int a = Integer.parseInt(st.nextToken());

                if(a==1) {
                    list.add(new Node(i,j));
                    cheeze_cnt++;
                }

                map[i][j] = a;
            }
        }

        list_visited = new boolean[list.size()];

        while(true){

            if(cheeze_cnt==0) break;

            visited = new boolean[N][M];
            spread(0,0);

            melt();

            time++;

        }


        System.out.println(time);


    }

    public static void spread(int x,int y){

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(check_bound(nx,ny)) continue;

            if(!visited[nx][ny]&&(map[nx][ny]==0||map[nx][ny]==2)){
                visited[nx][ny] =true;
                map[nx][ny]=2;
                spread(nx,ny);
            }
        }

    }
    public static void melt(){

        List<Node> melt_cheeze = new ArrayList<>();

        if(list.isEmpty()) return ;

        for(int i=0;i<list.size();i++){

            if(list_visited[i]) continue;

            Node n = list.get(i);

            int x = n.x;
            int y = n.y;
            int cnt = 0;

            for(int j=0;j<4;j++){
                int nx = x+ dx[j];
                int ny = y+ dy[j];

                if(map[nx][ny]==2) cnt++;
            }

            if(cnt>=2) {
                melt_cheeze.add(new Node(n.x,n.y));
                list_visited[i]=true;
                cheeze_cnt--;
            }
        }

        for(Node a:melt_cheeze){
            map[a.x][a.y] = 2;
        }

    }

    public static boolean check_bound(int x,int y){

        return x<0||x>=N||y<0||y>=M;
    }
}