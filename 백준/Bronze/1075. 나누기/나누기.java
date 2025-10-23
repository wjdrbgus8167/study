import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());
        long F = Long.parseLong(br.readLine().trim());

        long base = (N / 100) * 100; 
        int ans = 0;

        for (int i = 0; i < 100; i++) {
            if ((base + i) % F == 0) {
                ans = i;
                break; 
            }
        }

        System.out.printf("%02d", ans);
    }
}
