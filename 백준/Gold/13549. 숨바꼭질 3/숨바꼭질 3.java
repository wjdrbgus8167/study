import java.io.*;
import java.util.*;

public class Main{

    static int N,K;
    static final int Max=200000;
    static int[] dx;
    static int min_day;
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dx = new int[Max+1];
        min_day = 0;

        bfs();

        System.out.println(min_day);
    }

    public static void bfs(){

        ArrayDeque<Integer> que = new ArrayDeque<>();
        Arrays.fill(dx,Integer.MAX_VALUE);

        dx[N] = 0;
        que.add(N);

        while(!que.isEmpty()){

            int next_dx = que.poll();

            if(next_dx==K){
                min_day = dx[next_dx];
            }

            int move = next_dx*2;

            if(move<=Max&&dx[move]>dx[next_dx]){
                dx[move] = dx[next_dx];
                que.add(move);
            }

            move = next_dx-1;

            if(0<=move&&dx[move]>dx[next_dx]+1){
                dx[move] = dx[next_dx]+1;
                que.add(move);
            }

            move = next_dx+1;

            if(move<=Max && dx[move]>dx[next_dx]+1){
                dx[move] = dx[next_dx]+1;
                que.add(move);
            }

        }

    }
}