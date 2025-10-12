import java.io.*;
import java.util.*;

public class Main {

    static int result=0;
    static int N ;
    static int S;
    static int[] num;

    public static void main(String[] args) throws Exception {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        if(S==0) result--;

        System.out.println(result);


    }

    public static void dfs(int depth,int sum){

        if(depth==N){

            if(sum==S){

                result++;
            }
            return;
        }

        dfs(depth+1, sum+num[depth]);
        dfs(depth+1,sum);
    }


}
