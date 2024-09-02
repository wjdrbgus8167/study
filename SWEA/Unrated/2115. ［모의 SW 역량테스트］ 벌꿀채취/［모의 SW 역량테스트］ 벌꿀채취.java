import java.io.*;
import java.util.*;

class Node5 {
    int x;
    int y;

    public Node5(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {

    static int N, M, C;
    static int[][] honey;
    static boolean[][] visited;
    static ArrayList<Node5> list;
    static ArrayList<Node5> list1;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            honey = new int[N][N];
            visited = new boolean[N][N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    honey[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;

            // 첫 번째 꿀통 선택
            for (int a = 0; a < N; a++) {
                for (int i = 0; i <= N - M; i++) {
                    list = new ArrayList<>();
                    for (int j = i; j < i + M; j++) {
                        list.add(new Node5(a, j));
                        visited[a][j] = true;
                    }

                    // 두 번째 꿀통 선택
                    for (int b = a; b < N; b++) {
                        for (int j = 0; j <= N - M; j++) {
                            if (b == a && j < i + M) continue;

                            list1 = new ArrayList<>();
                            for (int k = j; k < j + M; k++) {
                                if (!visited[b][k]) {
                                    list1.add(new Node5(b, k));
                                }
                            }

                            if (list1.size() == M) {
                               getHoney();
                            }
                        }
                    }

                    // 첫 번째 꿀통 초기화
                    for (int j = i; j < i + M; j++) {
                        visited[a][j] = false;
                    }
                }
            }

            sb.append("#"+tc+" "+result+"\n");
        }
        System.out.println(sb);
    }

    public static void getHoney() {
        int maxProfit1 = getMaxProfit(list, 0, 0, 0);
        int maxProfit2 = getMaxProfit(list1, 0, 0, 0);

        result = Math.max(result, maxProfit1 + maxProfit2);
    }

    public static int getMaxProfit(ArrayList<Node5> cells, int idx, int currentSum, int currentProfit) {
        if (currentSum > C) {
            return 0; // 현재 꿀의 합이 C를 넘으면 이 부분집합은 유효하지 않음
        }

        if (idx == cells.size()) {
            return currentProfit; // 모든 셀을 다 검사한 경우, 현재까지의 이익 반환
        }

        // 이 셀을 선택하는 경우
        int include = getMaxProfit(cells, idx + 1, 
                                   currentSum + honey[cells.get(idx).x][cells.get(idx).y], 
                                   currentProfit + honey[cells.get(idx).x][cells.get(idx).y] * honey[cells.get(idx).x][cells.get(idx).y]);

        // 이 셀을 선택하지 않는 경우
        int exclude = getMaxProfit(cells, idx + 1, currentSum, currentProfit);

        // 더 큰 이익을 반환
        return Math.max(include, exclude);
    }
}
