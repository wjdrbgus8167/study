import java.util.*;

class Solution {

    public int solution(String begin, String target, String[] words) {

        boolean[] visited = new boolean[words.length];

        Queue<String> que = new ArrayDeque<>();

        que.add(begin);

        int count = 0;

        while (!que.isEmpty()) {

            int size = que.size();

            for (int i = 0; i < size; i++) {

                String current = que.poll();

                if(current.equals(target)) return count;
                
                for(int j=0;j<words.length;j++){
                    
                    if(visited[j]|| !canChange(current,words[j])) continue;
                    
                    visited[j] =true;
                    que.add(words[j]);
                    
                }
            }

            count++;
        }

        return 0;
    }

    static boolean canChange(String a, String b) {

        int count = 0;

        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}