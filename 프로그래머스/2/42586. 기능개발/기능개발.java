import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] answer = {};
        
        Queue<int[]> que = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){

            que.offer(new int[]{progresses[i],speeds[i]});
        }

        ArrayList<Integer> list = new ArrayList<>();

        while(!que.isEmpty()){

            int size = que.size();

            for(int i=0;i<size;i++){

                int[] progre = que.poll();

                que.offer(new int[]{progre[0]+progre[1],progre[1]});
            }


            int cnt =0;

            for(int i=0;i<size;i++){

                int[] now_progre = que.peek();

                if(now_progre[0]<100) break;

                que.poll();
                cnt++;
            }

            if(cnt!=0) list.add(cnt);

        }
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}