import java.util.HashSet;
import java.util.Set;

class Solution {
    
    private static char[] num;
    private static boolean[] visited;
    private static Set<Integer> prime_set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer =0;

        num = numbers.toCharArray();
        visited = new boolean[num.length];

        combination("");

        int prime_cnt=0;

        for(int a : prime_set){

            if(isPrime(a)) prime_cnt++;
        }

        answer = prime_cnt;

        return answer;
    }
    
    private static void combination(String cur){

        if(!cur.isEmpty()){
            prime_set.add(Integer.parseInt(cur));
        }

        for(int i=0;i<num.length;i++){
            if(!visited[i]){
                visited[i] = true;
                combination(cur+num[i]);
                visited[i] = false;
            }
        }
    }

    private static boolean isPrime(int n){

        if(n<=1) return false;

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }

        return true;
    }
}