import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(st.nextToken());
            long sum = sumOfMultiples(N, 3) + sumOfMultiples(N, 7) - sumOfMultiples(N, 21);
            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }

    
    private static long sumOfMultiples(long N, int num) {
        long count = N / num;
       
        return num * count * (count + 1) / 2;
    }
}
