import java.io.*;
import java.util.*;


class Point{

    int x,y;

    public Point(int x,int y){
        this.x =x;
        this.y = y;

    }
}
class Main{

    static int N,M;

    static boolean[][] visited;
    static int[][] map;
    static int[][] copy_map;
    static List<Point> virus ;
    static boolean[] select;

    static int empty =0;

    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};

    static int min_day =Integer.MAX_VALUE;

    public static void main(String[] args )throws IOException{

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        copy_map = new int[N][N];
        visited= new boolean[N][N];
        virus = new ArrayList<>();

        for(int i=0;i<N;i++){

            st =new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){
                int a = Integer.parseInt(st.nextToken());

                if(a==2) {
                    virus.add(new Point(i,j));
                }else if(a==0){
                    empty++;
                }
                map[i][j] = a;
                copy_map[i][j]=a;
            }
        }

        select = new boolean[virus.size()];

        if(empty==0){
            System.out.println("0");
        }else{

            select_virus(0,0);

            if(min_day==Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(min_day);
            }
        }



    }

    public static void select_virus(int start,int cnt){

        if(cnt ==M){

            List<Point>  list= new ArrayList<>();

            for(int i=0;i<select.length;i++){
                if(select[i]){
                    Point p = virus.get(i);
                    list.add(new Point(p.x,p.y));
                    map[p.x][p.y]=3;

                }
            }

            int result = spread(list);

            min_day  =Math.min(min_day,result);

            for(int i=0;i<N;i++){

                for(int j=0;j<N;j++){

                    map[i][j] = copy_map[i][j];
                }
            }
            return ;
        }

        for(int i=start;i<virus.size();i++){
            if(!select[i]){
                select[i]=true;
                select_virus(i+1,cnt+1);
                select[i]=false;

            }
        }

    }

    // 바이러스 퍼트리기
    public static int spread(List<Point> list){

        ArrayDeque<Point> active_virus = new ArrayDeque<>();

        for(Point p :list) active_virus.add(new Point(p.x,p.y));

        int days=0;

        while(!active_virus.isEmpty()){

            int size =active_virus.size();

            for(int i=0;i<size;i++){

                Point p = active_virus.poll();

                for(int j=0;j<4;j++){
                    int nx = dx[j]+p.x;
                    int ny = dy[j]+p.y;

                    if(check_bound(nx,ny)) continue;

                    if(map[nx][ny]==2||map[nx][ny]==0) {
                        map[nx][ny] =3;
                        active_virus.add(new Point(nx,ny));
                    }

                }
            }

            days++;
            if(check_virus()){
                return days;
            }

        }

        return Integer.MAX_VALUE;


    }

    // 현재 바이러스 체크
    public static boolean check_virus(){

        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){

                if(map[i][j]==0) return false;
            }
        }

        return true;
    }

    public static boolean check_bound(int x,int y){

        return x<0||x>=N||y<0||y>=N;
    }
}