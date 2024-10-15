

import java.io.*;
import java.util.*;

class Point4 {
    int end;
    int time;

    public Point4(int end, int time) {
        this.end = end;
        this.time = time;
    }
}

public class Main {

    static int N, M, X;
    static ArrayList<Point4>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Point4(end, weight));
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            int goToX = dijkstra(i, X);
            int backToI = dijkstra(X, i);
            maxTime = Math.max(maxTime, goToX + backToI);
        }

        System.out.println(maxTime);
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] shortest = new int[N + 1];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[start] = 0;
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curLocation = cur[0];
            int curTime = cur[1];

            if (curLocation == end) return curTime;

            for (Point4 neighbor : list[curLocation]) {
                int newTime = curTime + neighbor.time;
                if (newTime < shortest[neighbor.end]) {
                    shortest[neighbor.end] = newTime;
                    queue.add(new int[]{neighbor.end, newTime});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
