import java.io.*;
import java.util.*;

class Main{

    static HashMap<String,String> map;
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            String domain = st.nextToken();
            String password = st.nextToken();

            map.put(domain,password);
        }

        for(int i=0;i<M;i++){
            String domain = br.readLine();

            sb.append(map.get(domain)+"\n");
        }
        System.out.println(sb);

    }
}