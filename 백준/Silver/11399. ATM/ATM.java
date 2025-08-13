import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main{

    static int N;
    static int people[],time[];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =  new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());

        people = new int[N];
        time = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        

        int now=0;
        int prev_sum=0;
        int sum=0;
        Arrays.sort(people);

        for(int i=0;i<N;i++){

            now = people[i]+prev_sum;
            sum += now;
            prev_sum = now;
        }

        
        System.out.println(sum);

    }


}