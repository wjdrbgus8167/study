import java.io.*;
import java.util.*;

class Main{

    static int N;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    static boolean[][] visited = new boolean[101][101];

    static ArrayList<Integer> dist;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            make_direction(x,y,d,g);

        }

        System.out.println(cnt_dragon());



    }
    public static void make_direction(int x,int y, int d, int g){
        
        dist = new ArrayList<>();
        visited[x][y] = true;
        dist.add(d);

        for(int i=1;i<=g;i++){

            for(int j=dist.size()-1;j>=0;j--){
                dist.add((dist.get(j)+1)%4);
            }
        }

        make_dragon(x,y);
    }

    public static void make_dragon(int nx,int ny){

        for(int i:dist){

            nx = dx[i]+nx;
            ny = dy[i]+ny;

            if(nx<0||nx>100||ny<0||ny>100) continue;

            visited[nx][ny] = true;
        }
    }

    public static int cnt_dragon(){
        
        int cnt =0;

        for(int i=0;i<100;i++){

            for(int j=0;j<100;j++){

                if(visited[i][j]&&visited[i+1][j]&&visited[i][j+1]&&visited[i+1][j+1]) cnt++;
            }
        }

        return cnt;
    }
}