import java.util.*;

class Solution {
    public static int solution(String s) {
        int answer = s.length();

        StringBuilder sb ;

        // s길이에 따라 ex) s=>4 ->2
        for(int len=1;len<=s.length()/2;len++){

            sb = new StringBuilder();


            // 1,2,... 끊기
            String prev = s.substring(0,len);
            int cnt=1;

            for(int i=len;len+i<=s.length();i+=len){
                String cur = s.substring(i,i+len);

                if(cur.equals(prev)){
                    cnt++;
                }else{
                    if(cnt>1) sb.append(cnt);
                    sb.append(prev);
                    prev = cur;
                    cnt =1;
                }
            }

            if(cnt>1) sb.append(cnt);
            sb.append(prev);
            sb.append(s.substring((s.length() / len) * len));
            answer = Math.min(answer,sb.toString().length());



        }


        return answer;
    }
}