

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int beer = 20;
    static int[][] locations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            locations = new int[n + 2][2]; 
            
            // 상근이네 집 좌표
            st = new StringTokenizer(br.readLine());
            locations[0][0] = Integer.parseInt(st.nextToken());
            locations[0][1] = Integer.parseInt(st.nextToken());
            
            // 편의점 좌표
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                locations[i][0] = Integer.parseInt(st.nextToken());
                locations[i][1] = Integer.parseInt(st.nextToken());
            }
            
            // 페스티벌 좌표
            st = new StringTokenizer(br.readLine());
            locations[n + 1][0] = Integer.parseInt(st.nextToken());
            locations[n + 1][1] = Integer.parseInt(st.nextToken());
            
            // BFS로 페스티벌 도달 가능 여부 확인
            if (canReachFestival()) {
                sb.append("happy\n");
            } else {
                sb.append("sad\n");
            }
        }
        
        System.out.print(sb);
    }
    
    public static boolean canReachFestival() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 2];
        
        queue.add(0); 
        visited[0] = true;
        
        while (!queue.isEmpty()) {
           
        	int current = queue.poll();
            int curX = locations[current][0];
            int curY = locations[current][1];
            
            if (current == n + 1) { // 페스티벌에 도착한 경우
                return true;
            }
            
            for (int i = 0; i < n + 2; i++) {
             
            	if (!visited[i]) {
                    int nextX = locations[i][0];
                    int nextY = locations[i][1];
                    int distance = Math.abs(curX - nextX) + Math.abs(curY - nextY);
                    
                    // 이동 가능한 거리인지 확인
                    if (distance <= beer * 50) {
                        queue.add(i);
                        visited[i] = true; // 편의점 방문 처리
                    }
                }
            }
        }
        
        return false;
    }
}
