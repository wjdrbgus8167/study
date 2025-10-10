import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            if (x == 0) {
                if (pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            } else {
                pq.offer(x);
            }
        }
        System.out.print(sb.toString());
    }
}
