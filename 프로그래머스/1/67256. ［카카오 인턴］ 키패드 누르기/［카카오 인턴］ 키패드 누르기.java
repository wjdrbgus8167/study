class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        
        int left_x = 3;
        int left_y = 0;
        
        int right_x = 3;
        int right_y = 2;
        
        
        for(int i=0;i<numbers.length;i++){
            
            int num = numbers[i];
            
            int x ;
            int y ;
            if(num==0){
                x = 3;
                y = 1;
            }else{
                x = (num-1)/3;
                y = (num-1)%3;
            }
            
            if(num==1||num==4||num==7){
                
                sb.append("L");
                
                left_x= x;
                left_y =y;
            }else if(num==3||num==6||num==9){
                sb.append("R");
                
                right_x = x;
                right_y = y;
                
            }else{
                
                int distance_right = Math.abs(right_x-x) + Math.abs(right_y-y);
                int distance_left = Math.abs(left_x-x) + Math.abs(left_y-y);
                
                if(distance_right>distance_left||(distance_right==distance_left&&hand.equals("left"))){
                    sb.append("L");
                    left_x = x;
                    left_y = y;
                }else{
                    sb.append("R");
                    right_x = x;
                    right_y = y;
                }
                    
            }
            
        }
        
        
        return answer=sb.toString();
    }
}