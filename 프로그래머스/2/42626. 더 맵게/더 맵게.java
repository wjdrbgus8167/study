import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        int cnt= 0;

        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->a-b);

        for(int i=0;i<scoville.length;i++){
            if(K>scoville[i]) cnt++;

            pq.add(scoville[i]);
        }

        while(cnt!=0){

            if(pq.size()<=1&&pq.peek()<K){
                return -1;
            }
            
            int first_scoville = pq.poll();
            if(first_scoville<K) cnt--;

            int second_scoville = pq.poll();
            if(second_scoville<K) cnt--;


            int new_scoville =first_scoville+second_scoville*2;

            if(new_scoville<K) cnt++;
            pq.add(new_scoville);
            answer++;
        }


        return answer;
    }
}