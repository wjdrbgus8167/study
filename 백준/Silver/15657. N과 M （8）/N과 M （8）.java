import java.io.*;
import java.util.*;

public class Main{

    static int N,M;
    static int arr[];
    static int result[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0,0);

        System.out.println(sb);
    }

    public static void dfs(int cnt, int depth){

        if(depth == M){
            for(int a :result){
                sb.append(a+" ");
            }
            sb.append("\n");

            return ;
        }
        
        for(int i=cnt;i<N;i++){
            result[depth] = arr[i];
            dfs(i,depth+1);

        }

    }
}