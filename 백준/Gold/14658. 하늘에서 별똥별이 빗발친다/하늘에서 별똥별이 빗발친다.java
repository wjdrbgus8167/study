import java.io.*;
import java.util.*;

class Point {

    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M, L, K;
    static List<Point> stars = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new Point(x, y));
        }
        
        int maxCaught = 0;

        for (int i = 0; i < K; i++) {

            int baseX = stars.get(i).x;

            for (int j = 0; j < K; j++) {

                int baseY = stars.get(j).y;
                int caught = 0;

                for (int t = 0; t < K; t++) {

                    Point p = stars.get(t);

                    if (baseX <= p.x && p.x <= baseX + L && baseY <= p.y && p.y <= baseY + L) {
                        caught++;
                    }
                }
                if (caught > maxCaught) maxCaught = caught;
            }
        }

        System.out.println(K - maxCaught);
    }
}
