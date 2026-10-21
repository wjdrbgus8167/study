import java.util.*;

class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        HashMap<Integer,Integer> totalmap = new HashMap<>();
        
        for(int i=0;i<records.length;i++){
            
            String[] info = records[i].split(" ");
            
            int car_num = Integer.parseInt(info[1]);
            String[] time = info[0].split(":");
            
            int minute = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            
            if(info[2].equals("IN")){
                
                map.put(car_num,minute);
                if(!totalmap.containsKey(car_num)){
                    totalmap.put(car_num,0);
                }
                
                
            }else{
                int inTime = map.remove(car_num);
                
                int parkingTime = minute - inTime;
                
                totalmap.put(car_num, totalmap.getOrDefault(car_num,0)+parkingTime);
            }
            
        }
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            
            int car_num = entry.getKey();
            int inTime = entry.getValue();
            
            int parkingTime = 23*60+59 - inTime;
            
            totalmap.put(car_num, totalmap.get(car_num)+parkingTime);
        }
        
        List<Integer> carNums = new ArrayList<>(totalmap.keySet());
        Collections.sort(carNums);
        
        int[] answer = new int[carNums.size()];
        
        for(int i=0;i<carNums.size();i++){
            
            int totalTime = totalmap.get(carNums.get(i));
            
            int fee = fees[1];
            
            if(totalTime > fees[0]){
                int extraTime = totalTime - fees[0];
                
                int units =(extraTime + fees[2]-1)/fees[2];
                fee += units*fees[3];
            }
            
            answer[i] = fee;
        }
    
    return answer;
    
    }
    
    
}