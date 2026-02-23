import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        int answer =0;

        // 우선순위 1. 작업의 소요시간이 짧은 것, 2. 작업의 요청 시각이 빠른 것 3. 작업의 번호가 작은 것
        // a[0] = 작업의 요청의 시각, a[1] = 작업의 소요시간, a[2] = 작업의 번호

        //time 기준으로 도착한 job만 pq에 넣고,
        //pq에서 가장 짧은 작업 실행

        // 요청 시간 기준으로 정렬
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);

        // 작업 소요시간이 짧은 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);


        int time = 0;
        int idx = 0;
        int jobAverageTime = 0;

        // idx => 현재 시간에 따른 작업을 보기 위한 job의 인덱스 관리 변수

        while(idx<jobs.length||!pq.isEmpty()){

            // 현재 시간까지 도착한 작업만 큐에 넣기
            while(idx < jobs.length&&jobs[idx][0]<=time){
                pq.add(jobs[idx]);
                idx++;
            }

            if(pq.isEmpty()){
                // 할 일 없으면 시간 점프
                time = jobs[idx][0];
            }else{
                int[] job = pq.poll();
                time += job[1];
                jobAverageTime +=time - job[0];
            }
        }


        int size = jobs.length;

        answer = jobAverageTime/size;

        return answer;
    }
}