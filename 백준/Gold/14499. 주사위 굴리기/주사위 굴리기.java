import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

class Main{

    static int N,M;
    static int[][] map;
    static int x,y;

    static int[][] dice = new int[4][3];

    static int[] dx = {0,0,0,-1,1};
    static int[] dy = {0,1,-1,0,0};

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){

                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<K;i++){
            int command = Integer.parseInt(st.nextToken());

            roll(command);
        }



    }

    public static void roll(int command){

        int nx = x+dx[command];
        int ny = y+dy[command];

        if(check_bound(nx,ny)) return ;

        x = nx;
        y = ny;
        switch (command){

            // 동쪽
            case 1:

                if(map[nx][ny]==0){
                    map[nx][ny] = dice[1][2];
                    int temp = dice[3][1];
                    dice[3][1] = map[nx][ny];
                    dice[1][2] = dice[1][1];
                    dice[1][1] = dice[1][0];
                    dice[1][0] = temp;


                }else{

                    int temp = dice[3][1];
                    dice[3][1] = map[nx][ny];
                    map[nx][ny] =0;
                    dice[1][2] = dice[1][1];
                    dice[1][1] = dice[1][0];
                    dice[1][0] = temp;

                }

                System.out.println(dice[1][1]);
                break;
            //서쪽
            case 2:

                if(map[nx][ny]==0){

                    map[nx][ny] = dice[1][0];
                    int temp = dice[3][1];
                    dice[3][1] = map[nx][ny];
                    dice[1][0] = dice[1][1];
                    dice[1][1] = dice[1][2];
                    dice[1][2] = temp;


                }else{

                    int temp = dice[3][1];
                    dice[3][1] = map[nx][ny];
                    map[nx][ny]=0;
                    dice[1][0] = dice[1][1];
                    dice[1][1] = dice[1][2];
                    dice[1][2] = temp;


                }


                System.out.println(dice[1][1]);
                break;
            //북쪽
            case 3:
                if(map[nx][ny]==0){

                    map[nx][ny] = dice[0][1];
                    int temp = dice[3][1];
                    dice[3][1] = map[nx][ny];
                    dice[0][1] = dice[1][1];
                    dice[1][1] = dice[2][1];
                    dice[2][1] = temp;


                }else{

                    int temp = dice[3][1];
                    dice[3][1] = map[nx][ny];
                    map[nx][ny]=0;
                    dice[0][1] = dice[1][1];
                    dice[1][1] = dice[2][1];
                    dice[2][1] = temp;


                }
                System.out.println(dice[1][1]);
                break;
            // 남쪽
            case 4:

                if(map[nx][ny]==0){

                    map[nx][ny] = dice[2][1];
                    int temp = dice[3][1];
                    dice[3][1] = map[nx][ny];
                    dice[2][1] = dice[1][1];
                    dice[1][1] = dice[0][1];
                    dice[0][1] = temp;


                }else{

                    int temp = dice[3][1];
                    dice[3][1] = map[nx][ny];
                    map[nx][ny]=0;
                    dice[2][1] = dice[1][1];
                    dice[1][1] = dice[0][1];
                    dice[0][1] = temp;


                }
                System.out.println(dice[1][1]);
                break;

            default:
                break;

        }


    }

    public static boolean check_bound(int r, int c){
        return r<0||r>=N||c<0||c>=M;
    }
}