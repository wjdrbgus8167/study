import java.util.Queue;
import java.util.LinkedList;


class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int currentWeight = 0;
        int idx = 0;

        // 다리를 빈 공간으로 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (idx < truck_weights.length) {
            time++;

            // 한 칸 전진
            currentWeight -= bridge.poll();

            // 트럭 올릴 수 있으면
            if (currentWeight + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }

        // 마지막 트럭이 다리를 건너는 시간
        return time + bridge_length;
    }
}