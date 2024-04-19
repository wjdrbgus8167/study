import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class  Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

     
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int S_num = Integer.parseInt(st.nextToken());
            int T_num = Integer.parseInt(st.nextToken());

         
            String[] s_n = new String[S_num];
            String[] t_n = new String[T_num];

         
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < S_num; x++) {
                s_n[x] = st.nextToken();
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int y = 0; y < T_num; y++) {
                t_n[y] = st.nextToken();
            }

            sb.append("#").append(i + 1).append(" ");

            int Q = Integer.parseInt(br.readLine());
            for (int k = 0; k < Q; k++) {
                int year = Integer.parseInt(br.readLine());

             
                int s_index = (year - 1) % S_num;
                int t_index = (year - 1) % T_num;

              
                sb.append(s_n[s_index]).append(t_n[t_index]).append(" ");
            }
          
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
