class Solution {
    
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(numbers,0,0,target);
        
        return answer = cnt;
    }
    
    public static void dfs(int[] numbers,int start, int now_target,int target){
        
        if(start==numbers.length){
            
            if(now_target==target) {
           
                cnt++;
            return ;
            }
            
            return ;
        }
        
        
        
            
        dfs(numbers,start+1, numbers[start]+now_target,target);
        dfs(numbers,start+1, numbers[start]*(-1) +now_target, target );
            
            
        
        return ;
    }
        
}