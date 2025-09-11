import java.io.*;
import java.util.*;

class Main{

    static int[][] arr;
    static int[]dx = {0,1,0,-1};
    static int[]dy = {-1,0,1,0};

    static int[]dsx ={-1, 1, -2, -1, 1, 2, -1, 1, 0};
    static int[]dsy ={ 1, 1,  0,  0, 0, 0, -1, -1, -2};
    static int[]sandRatio = {1,1,2,7,7,2,10,10,5};
    static int N;
    static int out_sand;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        arr = new int[N][N];

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        out_sand =0;

        tornado(N/2,N/2,0);

        System.out.println(out_sand);
    }

    public static void tornado(int x,int y, int dir){

        int step =1;

        while(true){

            for(int i=0;i<2;i++){

                for(int j=0;j<step;j++){

                    x +=dx[dir];
                    y +=dy[dir];

                    int sand = arr[x][y];
                    arr[x][y]=0;

                    spread_sand(x,y,sand,dir);

                    if(x==0&&y==0){
                        return;
                    }

                }

                dir = (dir+1)%4;
            }
            step++;
        }


    }

    public static void spread_sand(int x, int y,int sand, int dir){

        //밖에 나간 거
        int spread_Total =0;

        for(int i=0;i<9;i++){

            // 현재 왼쪽으로 퍼지는 바람 기준으로 잡은 방향 벡터 꺼내서 dir에 맞게 90도 회전시키기(반시계)
            int rx = dsx[i];
            int ry = dsy[i];

            for(int j=0;j<dir;j++){

                int temp = rx;
                rx = -ry;
                ry = temp;
            }

            int nx = x+rx;
            int ny = y+ry;

            int sand_amount= sand*sandRatio[i]/100;
            spread_Total +=sand_amount;

            if(nx<0||ny<0||nx>=N||ny>=N){
                out_sand +=sand_amount;
            }else{
                arr[nx][ny] +=sand_amount;
            }

        }

        int alphaX = x+dx[dir];
        int alphaY = y+dy[dir];

        int alphaAmount = sand-spread_Total;

        if (alphaX < 0 || alphaY < 0 || alphaX >= N || alphaY >= N) {
            out_sand += alphaAmount;
        } else {
            arr[alphaX][alphaY] += alphaAmount;
        }

    }
}