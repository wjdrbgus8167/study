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
            
            if(num==1||num==4||num==7){
                
                sb.append("L");
                
                if(num==1){
                  left_x =0;
                  left_y =0;  
                }else if(num==4){
                  left_x =1;
                  left_y =0;
                }else{
                  left_x =2;
                  left_y =0;
                } 
            }else if(num==3||num==6||num==9){
                sb.append("R");
                
                if(num==3){
                  right_x =0;
                  right_y =2;  
                }else if(num==6){
                  right_x =1;
                  right_y =2;
                }else{
                  right_x =2;
                  right_y =2;
                } 
            }else{
                
                if(num==2){
                    int distance_right = Math.abs(right_x-0) + Math.abs(right_y-1);
                    int distance_left = Math.abs(left_x-0) + Math.abs(left_y-1);
                    
                    if(distance_right>distance_left){
                        sb.append("L");
                        left_x = 0;
                        left_y = 1;
                    }else if(distance_right<distance_left){
                        sb.append("R");
                        right_x = 0;
                        right_y = 1;
                        
                    }else{
                        if(hand.equals("right")){
                             sb.append("R");
                            right_x = 0;
                            right_y = 1;
                        }else{
                             sb.append("L");
                            left_x = 0;
                            left_y = 1;
                        }
                    }
                }else if(num==5){
                    int distance_right = Math.abs(right_x-1) + Math.abs(right_y-1);
                    int distance_left = Math.abs(left_x-1) + Math.abs(left_y-1);
                    
                    if(distance_right>distance_left){
                        sb.append("L");
                        left_x = 1;
                        left_y = 1;
                    }else if(distance_right<distance_left){
                        sb.append("R");
                        right_x = 1;
                        right_y = 1;
                        
                    }else{
                        if(hand.equals("right")){
                             sb.append("R");
                            right_x = 1;
                            right_y = 1;
                        }else{
                             sb.append("L");
                            left_x = 1;
                            left_y = 1;
                        }
                    }
                }else if(num==8){
                    int distance_right = Math.abs(right_x-2) + Math.abs(right_y-1);
                    int distance_left = Math.abs(left_x-2) + Math.abs(left_y-1);
                    
                    if(distance_right>distance_left){
                        sb.append("L");
                        left_x = 2;
                        left_y = 1;
                    }else if(distance_right<distance_left){
                        sb.append("R");
                        right_x = 2;
                        right_y = 1;
                        
                    }else{
                        if(hand.equals("right")){
                             sb.append("R");
                            right_x = 2;
                            right_y = 1;
                        }else{
                             sb.append("L");
                            left_x = 2;
                            left_y = 1;
                        }
                    }
                }else if(num==0){
                    int distance_right = Math.abs(right_x-3) + Math.abs(right_y-1);
                    int distance_left = Math.abs(left_x-3) + Math.abs(left_y-1);
                    
                    if(distance_right>distance_left){
                        sb.append("L");
                        left_x = 3;
                        left_y = 1;
                    }else if(distance_right<distance_left){
                        sb.append("R");
                        right_x = 3;
                        right_y = 1;
                        
                    }else{
                        if(hand.equals("right")){
                             sb.append("R");
                            right_x = 3;
                            right_y = 1;
                        }else{
                             sb.append("L");
                            left_x = 3;
                            left_y = 1;
                        }
                    }
                }
            }
        }
        
        
        return answer=sb.toString();
    }
}