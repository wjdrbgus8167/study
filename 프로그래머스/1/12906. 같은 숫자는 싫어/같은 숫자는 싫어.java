import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        
        Stack<Integer> stack = new Stack<>();
        
        
        for(int i=0;i<arr.length;i++){
            
            if(!stack.isEmpty()&&stack.peek() == arr[i]){
                stack.pop();
            }
            
            stack.push(arr[i]);
            
        }
        
        int size = stack.size();
        int[] answer = new int[size];
        
        for(int i=size-1;i>=0;i--){
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}