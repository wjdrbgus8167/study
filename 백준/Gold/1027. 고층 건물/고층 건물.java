import java.io.*;
import java.util.*;

class Main{

    static int N;
    static int[] building;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        building =new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            building[i] = Integer.parseInt(st.nextToken());
        }

        int max_height = 0;

        for(int i=0;i<N;i++){

            int result = check_building(i);

            max_height = Math.max(result,max_height);
        }

        System.out.println(max_height);

    }

    public static int check_building(int num){

        int cnt =0;
        double tmp = 0;

        for(int i=num-1;i>=0;i--){

            double slope= (double)(building[num]-building[i])/(num-i);

            if(i==num-1||tmp>slope){
                cnt++;
                tmp = slope;
            }
        }

        for(int i=num+1;i<N;i++){

            double slope= (double)(building[num]-building[i])/(num-i);

            if(i==num+1||tmp<slope){
                cnt++;
                tmp = slope;
            }
        }

        return cnt;
    }
}