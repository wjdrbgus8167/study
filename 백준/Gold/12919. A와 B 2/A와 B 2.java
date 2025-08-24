import java.io.*;
import java.util.*;

public class Main {
    static String S, T;
    static boolean possible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = st.nextToken();
        st = new StringTokenizer(br.readLine());

        T = st.nextToken();

        dfs(T);
        System.out.println(possible ? 1 : 0);
    }

    static void dfs(String cur) {
        if (possible) return;
        if (cur.length() < S.length()) return;

        if (cur.equals(S)) {
            possible = true;
            return;
        }


        if (cur.charAt(cur.length() - 1) == 'A') {
            dfs(cur.substring(0, cur.length() - 1));
        }


        if (cur.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(cur.substring(1));
            dfs(sb.reverse().toString());
        }
    }
}
