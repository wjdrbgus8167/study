import java.io.*;
import java.util.*;

class Main{

    static int[] map;
    static int W;
    static int water_weight =0;
    public static void main(String[] args)throws IOException{

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        map = new int[W];

        for(int i=0;i<W;i++){
            int a = Integer.parseInt(st.nextToken());
            map[i] = a;
        }

        start();
        
        System.out.println(water_weight);

    }
    public static void start(){

        // 각 열의 끝은 빗물이 고일 수 없기 때문에 탐색에서 제외
        for(int i=1;i<W-1;i++){

            // 현재 나의 위치에서 왼쪽, 오른족 모두 나보다 높은 블록이 있어야 됨.
            int left = 0;
            int right =0;

            for(int j=0;j<i;j++) left = Math.max(left,map[j]);

            for(int j=i+1;j<W;j++) right = Math.max(right,map[j]);

            if(map[i]<left&&map[i]<right) water_weight +=Math.min(left,right)-map[i];


        }
    }
}