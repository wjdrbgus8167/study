import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static ArrayList<Integer> arr[];
    static boolean visited[];
    static int[] populations;
    static int minPopulation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        populations = new int[N+1];  // 각 구역의 인구수를 저장하는 배열

        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        // 각 구역의 인구수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
        }

        // 인접 리스트 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            for (int j = 0; j < t; j++) {
                int to = Integer.parseInt(st.nextToken());
                arr[i].add(to);
            }
        }

        visited = new boolean[N+1];
        minPopulation = Integer.MAX_VALUE;

        // 부분집합 생성 및 인구 차이 계산
        generateSubsets(1);

        // 결과 출력
        if (minPopulation == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minPopulation);
        }
    }

    // 부분집합을 생성하는 메서드
    public static void generateSubsets(int cnt) {
        if (cnt == N + 1) {
            ArrayList<Integer> section1 = new ArrayList<>();
            ArrayList<Integer> section2 = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                if (visited[i]) {
                    section1.add(i);
                } else {
                    section2.add(i);
                }
            }

            if (!section1.isEmpty() && !section2.isEmpty() && 
                isConnected(section1) && isConnected(section2)) {
                int sectionSum1 = 0;
                int sectionSum2 = 0;

                for (int i : section1) sectionSum1 += populations[i];
                for (int i : section2) sectionSum2 += populations[i];

                int diff = Math.abs(sectionSum1 - sectionSum2);
                minPopulation = Math.min(minPopulation, diff);
            }

            return;
        }

        visited[cnt] = true;
        generateSubsets(cnt + 1);

        visited[cnt] = false;
        generateSubsets(cnt + 1);
    }

    // 구역이 연결되어 있는지 확인하는 메서드
    public static boolean isConnected(ArrayList<Integer> list) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] checked = new boolean[N+1];

        queue.offer(list.get(0));
        checked[list.get(0)] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : arr[current]) {
                if (list.contains(neighbor) && !checked[neighbor]) {
                    checked[neighbor] = true;
                    queue.offer(neighbor);
                    cnt++;
                }
            }
        }

        return cnt == list.size();
    }
}
