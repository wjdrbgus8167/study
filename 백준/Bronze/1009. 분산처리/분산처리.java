import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            int d = (int)(a % 10);
            int ans;

            switch (d) {
                case 0: ans = 10; break;             
                case 1: ans = 1; break;
                case 2: ans = new int[]{2,4,8,6}[(int)((b-1)%4)]; break;
                case 3: ans = new int[]{3,9,7,1}[(int)((b-1)%4)]; break;
                case 4: ans = new int[]{4,6}[(int)((b-1)%2)]; break;
                case 5: ans = 5; break;
                case 6: ans = 6; break;
                case 7: ans = new int[]{7,9,3,1}[(int)((b-1)%4)]; break;
                case 8: ans = new int[]{8,4,2,6}[(int)((b-1)%4)]; break;
                case 9: ans = new int[]{9,1}[(int)((b-1)%2)]; break;
                default: ans = 10; 
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
