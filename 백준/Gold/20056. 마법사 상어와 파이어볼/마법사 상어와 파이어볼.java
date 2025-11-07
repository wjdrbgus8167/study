import java.io.*;
import java.util.*;

class FireBall {
    int x, y, m, s, d;
    public FireBall(int x, int y, int m, int s, int d){
        this.x = x;
        this.y = y;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

public class Main {

    static int N, M, K;
    static ArrayList<FireBall>[][] map;
    static ArrayDeque<FireBall> fireBalls = new ArrayDeque<>();

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1][N+1];
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i=0;i<M;i++){
            
            st = new StringTokenizer(br.readLine());
            
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            fireBalls.add(new FireBall(r,c,m,s,d));
        }

        simulate();

        System.out.println(getMass());
    }

    static void simulate(){

        while(K-- > 0){
            
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    map[i][j].clear();
                }
            }

            
            while(!fireBalls.isEmpty()){
                
                FireBall fb = fireBalls.poll();

                int move = fb.s % N;

                int nx = fb.x + dx[fb.d] * move;
                int ny = fb.y + dy[fb.d] * move;
                
                nx = (nx - 1 + N) % N + 1;
                ny = (ny - 1 + N) % N + 1;

                map[nx][ny].add(new FireBall(nx, ny, fb.m, fb.s, fb.d));
            }
            
            fireBalls.clear();

            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){

                    int size = map[i][j].size();
                    
                    if(size == 0) continue;

                    if(size == 1){
                        fireBalls.add(map[i][j].get(0));
                        continue;
                    }
                    
                    int sumM = 0;
                    int sumS = 0;
                   
                    boolean allEven = true;
                    boolean allOdd = true;

                    for(FireBall f : map[i][j]){
                        sumM += f.m;
                        sumS += f.s;
                        if(f.d % 2 == 0) allOdd = false;
                        else allEven = false;
                    }

                    int newM = sumM / 5;
                    if(newM == 0) continue; 

                    int newS = sumS / size;

                    int[] dirs;
                    
                    if(allEven || allOdd){
                        dirs = new int[]{0,2,4,6};
                    }else{
                        dirs = new int[]{1,3,5,7};
                    }

                    for(int d : dirs){
                        fireBalls.add(new FireBall(i, j, newM, newS, d));
                    }
                }
            }
        }
    }

    static int getMass(){
        int sum = 0;
        for(FireBall f : fireBalls) sum += f.m;
        return sum;
    }
}
