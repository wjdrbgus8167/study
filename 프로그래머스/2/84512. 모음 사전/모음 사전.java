import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    char[] alpha = {'A','E','I','O','U'};
    ArrayList<String> list = new ArrayList<>();
    
    public int solution(String word) {
         int answer = 0;
        list = new ArrayList<>();
        dfs(0,"");

        Collections.sort(list);

        answer = list.indexOf(word)+1;

        return answer;
    }
    
     private void dfs(int cnt,String words){

        if(cnt>5) return ;

        if(!words.isEmpty()){

            list.add(words);
        }

        for(int i=0;i<5;i++){

            dfs(cnt+1,words+alpha[i]);
        }

        return ;
    }
    
}