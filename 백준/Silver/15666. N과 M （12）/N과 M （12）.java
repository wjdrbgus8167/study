import java.io.*;
import java.util.*;

public class Main{


    static int N,M;
    static int arr[];
    static boolean visited[];
    static int result[];
    static StringBuilder sb = new StringBuilder();

   public static void main(String[] args) throws IOException{

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        permutation(0,0);

        System.out.println(sb);

   }

   public static void permutation(int cnt,int depth){

       if(depth == M ){

           for(int v : result){
               sb.append(v+" ");
           }

            sb.append("\n");

           return ;
       }
        int prev = Integer.MAX_VALUE;

       for(int i=cnt;i<N;i++){

           if(prev!=arr[i]){
               result[depth] = arr[i];
               prev  = arr[i];
               permutation(i,depth+1);

           }

       }
   }
}