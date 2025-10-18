import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());

        int maxSum = S1 + S2 + S3;
        int[] cnt = new int[maxSum + 1];

        for (int a = 1; a <= S1; a++) {
            for (int b = 1; b <= S2; b++) {
                for (int c = 1; c <= S3; c++) {
                    cnt[a + b + c]++;
                }
            }
        }

        int bestSum = 3; 
        int bestFreq = cnt[bestSum];
        for (int s = 4; s <= maxSum; s++) {
            if (cnt[s] > bestFreq) {
                bestFreq = cnt[s];
                bestSum = s;
            }
        }

        System.out.println(bestSum);
    }
}
