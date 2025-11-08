import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine().trim());

       
        int[] pos = new int[4];
        pos[1] = 1; pos[2] = 2; pos[3] = 3;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int tmp = pos[X];
            pos[X] = pos[Y];
            pos[Y] = tmp;
        }

        int answer = -1;
        for (int cup = 1; cup <= 3; cup++) {
            if (pos[cup] == 1) {
                answer = cup;
                break;
            }
        }
        System.out.println(answer);
    }
}
