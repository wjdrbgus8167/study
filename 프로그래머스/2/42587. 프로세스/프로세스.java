import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
       int answers = 0;

        Queue<int[]> que = new LinkedList<>();

        for(int i=0;i<priorities.length;i++){
            que.add(new int[]{priorities[i],i});
        }

        while(!que.isEmpty()){
            // 현재 나의 순위
            int[] current = que.poll();

            boolean check = false;

            // 나보다 높은 우선순위 체크
            for(int[] q : que){
                // 나보다 높으면 바로 break;
                if(q[0]>current[0]){
                    check = true;
                    break;
                }
            }

            if(check){
                // 다시 Queue에서 대기
                que.add(current);
            }else{
                // 현재 내가 가장 높은 우선순위
                answers++;
                if(current[1] ==location){
                    return answers;
                }
            }
        }

        return -1;
    }
}