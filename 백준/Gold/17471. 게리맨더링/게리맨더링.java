import java.io.*;
import java.util.*;

class Main{

    static int N;
    static ArrayList<Integer> list[];
    static int[] people;
    static boolean[] visited;
    static int result;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];

        for(int i=0;i<N;i++) list[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        people = new int[N];
        visited= new boolean[N];

        for(int i=0;i<N;i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int t= Integer.parseInt(st.nextToken());

            for(int j=0;j<t;j++){
                int a = Integer.parseInt(st.nextToken());

                list[i].add(a-1);
            }
        }

        result= Integer.MAX_VALUE;

        separate(0);

        if(result ==Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(result);
        }

    }

    public static void separate(int cnt){

        if(cnt==N){

            ArrayList<Integer> region1 = new ArrayList<>();
            ArrayList<Integer> region2 = new ArrayList<>();

            for(int i=0;i<N;i++){

                if(visited[i]){
                    region1.add(i);
                }else{
                    region2.add(i);
                }
            }
            if (region1.size()==0||region2.size()==0) return;

            if(check_region(region1)&&check_region(region2)){
                int difference = Math.abs(sum(region1)-sum(region2));

                result = Math.min(result,difference);
            }

            return;
        }


        visited[cnt] = true;
        separate(cnt + 1);
        visited[cnt] = false;
        separate(cnt + 1);
    }

    public static int sum(ArrayList<Integer> list){

        int sum =0;

        for(int i :list){
            sum +=people[i];
        }

        return sum;
    }

    public static boolean check_region(ArrayList<Integer>region){

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        boolean[] possible = new boolean[N];

        dq.add(region.get(0));
        possible[region.get(0)] =true;

        while(!dq.isEmpty()){

            int cur = dq.poll();


            for(int next : list[cur]){

                if(region.contains(next) && !possible[next]){
                    possible[next] = true;
                    dq.add(next);
                }

            }

        }

        for(int a : region){
            if(!possible[a]) return false;
        }


        return true;
    }
}