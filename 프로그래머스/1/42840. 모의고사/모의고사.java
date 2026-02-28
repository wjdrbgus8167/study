import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer ;
        
        ArrayList<int[]> list = new ArrayList<>();
        
        int[] one_math_giveup = {1,2,3,4,5};
        int[] two_math_giveup = {2,1,2,3,2,4,2,5};
        int[] three_math_giveup = {3,3,1,1,2,2,4,4,5,5};
        
        int one_idx = 5;
        int two_idx = 8;
        int three_idx = 10;
        
        int one_score = 0;
        int two_score = 0;
        int three_score = 0;
        
        for(int i=0;i<answers.length;i++){
                
            if(one_math_giveup[i%one_idx]==answers[i])one_score++;
            
            if(two_math_giveup[i%two_idx]==answers[i])two_score++;
            
            if(three_math_giveup[i%three_idx]==answers[i])three_score++;
        
            
        }
        
        list.add(new int[]{1,one_score});
        list.add(new int[]{2,two_score});
        list.add(new int[]{3,three_score});
       
        list.sort((a,b)->Integer.compare(b[1],a[1]));
        
        //answer = new int[list.size()];
        ArrayList<Integer> list1 = new ArrayList<>();
        
        int max= list.get(0)[1];
        
        for(int i=0;i<list.size();i++){
            if(max==list.get(i)[1]){
              list1.add(list.get(i)[0]);  
            }else{
                break;
            }
        }
        
        answer = new int[list1.size()];
        
        for(int i=0;i<list1.size();i++) answer[i]=list1.get(i);
        
        
        return answer;
    }
}