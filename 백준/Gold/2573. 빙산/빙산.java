import java.io.*;
import java.util.*;

class Main{


    static int N,M;
    static int[][] ice;
    static int[][] copy_ice;

    static int min_day=0;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited ;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ice = new int[N][M];
        copy_ice  =new int[N][M];

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int a = Integer.parseInt(st.nextToken());

                ice[i][j] = a;
                copy_ice[i][j]= a;
            }
        }



        while(true){

            if(!melt()) {
                min_day=0;
                break;

            }
            for(int i=0;i<N;i++){

                for(int j=0;j<M;j++){

                    copy_ice[i][j] = ice[i][j];
                }

            }
            visited = new boolean[N][M];
            int separate=0;

            for(int i=0;i<N;i++){

                for(int j=0;j<M;j++){

                    if(!visited[i][j]&&ice[i][j]>0) {

                        visited[i][j]=true;
                        ice_check(i,j);
                        separate++;
                    }
                }
            }

            if(separate>=2){

                min_day++;
                break;
            }

            min_day++;
        }

        System.out.println(min_day);

    }

    // 빙상 녹이기
    public static boolean melt(){
        boolean possible = false;

        for(int i=0;i<N;i++){

            for(int j=0;j<M;j++){

                if(copy_ice[i][j]==0) continue;

                int melting = 0;
                possible = true;

                for(int k=0;k<4;k++){
                    int nx = dx[k]+ i;
                    int ny = dy[k]+j;

                    if(copy_ice[nx][ny]==0) melting++;

                }

                if(ice[i][j]-melting<0) {
                    ice[i][j]=0;
                } else{
                    ice[i][j]-=melting;
                };
            }
        }

        return possible;

    }

    // 빙산 확인하기
    public static void ice_check(int x,int y){


        for(int i=0;i<4;i++){

            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx<0||nx>=N||ny<0||ny>=M) continue;

            if(!visited[nx][ny]&&ice[nx][ny]>0){
                visited[nx][ny] = true;
                ice_check(nx,ny);
            }
        }

    }
}