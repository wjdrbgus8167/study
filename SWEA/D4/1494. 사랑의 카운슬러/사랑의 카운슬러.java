

import java.io.*;
import java.util.*;

public class Solution{

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static ArrayList<Node> list;
    static boolean[] visited;
    static long min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Node(a, b));
            }

            visited = new boolean[N];
            min = Long.MAX_VALUE;

            combination(0, 0);

            System.out.println("#" + tc + " " + min);
        }
    }

    public static void combination(int idx, int count) {
        if (count == N / 2) {
            long vecX = 0, vecY = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    vecX += list.get(i).x;
                    vecY += list.get(i).y;
                } else {
                    vecX -= list.get(i).x;
                    vecY -= list.get(i).y;
                }
            }
            min = Math.min(min, vecX * vecX + vecY * vecY);
            return;
        }

        if (idx >= N) return;

        visited[idx] = true;
        combination(idx + 1, count + 1);

        visited[idx] = false;
        combination(idx + 1, count);
    }
}
