import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int answer = 0;
        int n = nums.length/2;
        
        HashSet<Integer> set  = new HashSet<>();
        
        for(int num : nums) set.add(num);
        
        if(set.size()<n) return answer =set.size();
        
        if(set.size()>=n) return answer = n;
        
        
        return answer;
    }
}