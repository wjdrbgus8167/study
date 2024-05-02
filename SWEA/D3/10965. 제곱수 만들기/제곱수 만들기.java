import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        
    	boolean[] visited = new boolean[10000001];
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(10000000) + 1; i++) {
            if (!visited[i]) {
                list.add(i);
                for (int j = i * i; j <= 10000000; j+=i) {
                    visited[j] = true;
                }
            }
        }
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            
        	int result = 1;
            int n = Integer.parseInt(br.readLine());
            int temp = n;
 
            for (int i = 0; i < list.size(); i++) {
                if (!visited[temp]) {
                    result = result * temp;
                    break;
                }
 
                int count = 0;
                while (temp % list.get(i) == 0) {
                    temp /= list.get(i);
                    count++;
                }
                if (count % 2 != 0) {
                    result = result * list.get(i);
                }
            }
            sb.append("#" + test_case + " " + result + "\n");
        }
        System.out.println(sb);
    }
}