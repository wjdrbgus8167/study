import java.util.*;

class Solution {
    
    public int[] solution(int[] fees, String[] records) {
         int[] answer;

        //fees 1. 기본 시간, 2. 기본 요금, 3. 단위 시간, 4. 단위 요금

        HashMap<String, Integer> cars = new HashMap<>();
        HashMap<String,Integer> result = new HashMap<>();

       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        for(String s : records){
            String[] car_info= s.split(" ");

            String[] times  = car_info[0].split(":");
            String hour = times[0];
            String minute = times[1];

            int time = Integer.parseInt(hour)*60 + Integer.parseInt(minute);

            String car_num = car_info[1];

            // 입차면 true, 출차면 false
            boolean in_out =car_info[2].equals("IN");

            if(in_out){
                cars.put(car_num,time);
            }else {
                result.put(car_num, result.getOrDefault(car_num,0)+time - cars.get(car_num));
                cars.put(car_num, -1);
            }

        }

        for(Map.Entry<String,Integer> e : cars.entrySet()){
            String k = e.getKey();
            int value = e.getValue();

            //출차 완료는 건너뛰기
            if(value ==-1) continue;

            int time = 23*60+59 - value;

            result.put(k,result.getOrDefault(k,0)+time);

        }


        for(Map.Entry<String,Integer>e : result.entrySet()){
            String k = e.getKey();
            int number = Integer.parseInt(k);
            int value = e.getValue();

            if(value<=fees[0]) {
                pq.add(new int[]{number, fees[1]});
                continue;
            }

            int fee = fees[1]+((value-fees[0]+fees[2]-1)/fees[2])*fees[3];

            pq.add(new int[]{number,fee});

        }
        answer = new int[pq.size()];
        int i=0;

        while (!pq.isEmpty()) {
            answer[i++] = pq.poll()[1];
        }


        return answer;
    
    }
    
    
}