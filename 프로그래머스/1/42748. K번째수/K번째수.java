import java.util.ArrayList;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
         int[] answer ={};

        ArrayList<Integer> list;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<commands.length;i++){

            list = new ArrayList<>();

            int start = commands[i][0]-1;
            int end = commands[i][1];
            int idx = commands[i][2]-1;

            for(int j=start;j<end;j++){
                list.add(array[j]);
            }

            list.sort((a,b)->a-b);


            result.add(list.get(idx));

        }

        answer = new int[result.size()];

        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }


        return answer;
    }
}