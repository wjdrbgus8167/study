import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
      
        int[] answer ={};
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<privacies.length;i++){
              
            String[] s = privacies[i].split(" ");
            String[] date = s[0].split("\\.");
            String type= s[1];
            
            // 현재 날짜 > 개인정보 수집일 + 유효기간 -> 통과 
              String[] todays = today.split("\\.");
              int today_year = Integer.parseInt(todays[0]);
              int today_month = Integer.parseInt(todays[1]);
              int today_day = Integer.parseInt(todays[2]);
            
            int pri_year = Integer.parseInt(date[0]);
              int pri_month = Integer.parseInt(date[1]);
              int pri_day = Integer.parseInt(date[2]);
            
                for(int j=0;j<terms.length;j++){
                    String[] t = terms[j].split(" ");
                    
                    if(t[0].equals(type)){
                        
                        int term_date = Integer.parseInt(t[1])*28;
                        
                        int today_sum =calculate(today_year,today_month,today_day);
                        
                        int pri_sum = calculate(pri_year,pri_month,pri_day)+term_date;
                        
                        if(today_sum>=pri_sum){
                          list.add(i+1);
                            break;
                        } 
                    }
            
            
             }   
        
        }
        
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);
        
        return answer ; 

}
    public static int calculate(int x,int y, int z){
        
        int x1 = x*12*28;
        int y1 = y*28;
        
        return x1+y1+z;
    }
}