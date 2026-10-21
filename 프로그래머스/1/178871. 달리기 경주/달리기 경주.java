import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
       String[] answer = {};

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<players.length;i++){

            map.put(players[i],i+1);
        }

        for(int j=0;j<callings.length;j++){

            // 이름 호명
            String name = callings[j];
            int sequence= map.get(name);

            // 다음 사람 
            String front_name = players[sequence-2];
            players[sequence-1]=front_name;
            players[sequence-2]= name;
            
            // 순위 반영 
            map.put(name,sequence-1);
            map.put(front_name,sequence);

        }

        answer = Arrays.copyOf(players,players.length);
        
        return answer;
    }
}