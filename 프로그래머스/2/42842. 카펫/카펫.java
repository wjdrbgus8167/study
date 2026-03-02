class Solution {
    public int[] solution(int brown, int yellow) {
         int[] answer = new int[2];
        int sum = brown + yellow;

        for(int i=3;i<=sum;i++){

            int col = i;
            int row = sum/col;

            if(row<3) continue;

            // 가로 길이 >= 세로 길이
            if(row>=col){
                if((row-2)*(col-2) ==yellow){
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }

        }

        return answer;
    }
}