import java.io.*;
import java.util.*;

class Node{
    int point,cnt;

    public Node(int point,int cnt){
        this.cnt = cnt;
        this.point = point;
    }

}
class Main{

    static int N,M;
    static int[] ladder;
    static int[] snake;
    static int min_cnt;
    static boolean[] visited;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        snake = new int[101];
        ladder = new int[101];
        visited = new boolean[101];

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        min_cnt = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ladder[x] =y;
        }

        for(int i=0;i<M;i++){

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            snake[x] = y;
        }


        bfs();

        System.out.println(min_cnt);
    }

    public static void bfs(){

        ArrayDeque<Node> que = new ArrayDeque<>();

        que.add(new Node(1,0));

        visited[1] =true;

        while(!que.isEmpty()){

            Node n = que.poll();

            if(n.point==100){
                min_cnt = Math.min(n.cnt,min_cnt);
                return ;

            }

            for(int i=1;i<=6;i++){

                int next_point = n.point+i;

                if(next_point>100) continue;

                if(!visited[next_point]){

                    if(ladder[next_point]!=0){

                        visited[next_point] = true;
                        que.add(new Node(ladder[next_point],n.cnt+1));


                    }else if(snake[next_point]!=0){
                        visited[next_point] = true;
                        que.add(new Node(snake[next_point],n.cnt+1));

                    }else{
                        visited[next_point] = true;
                        que.add(new Node(next_point,n.cnt+1));
                    }

                }


            }
        }

    }
}