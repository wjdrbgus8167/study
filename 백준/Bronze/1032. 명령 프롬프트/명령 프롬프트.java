import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        String first = br.readLine().trim();
        char[] pattern = first.toCharArray(); 

        for (int i = 1; i < N; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] != s.charAt(j)) {
                    pattern[j] = '?';
                }
            }
        }

        System.out.println(new String(pattern));
    }
}
