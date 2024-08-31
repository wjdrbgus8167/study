

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 알파벳 가중치 계산
        int[] alphabetWeight = new int[26];
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char ch = word.charAt(i);
                alphabetWeight[ch - 'A'] += Math.pow(10, length - i - 1);
            }
        }
       
        // 가중치가 높은 순서대로 정렬
        Integer[] numbers = new Integer[26];
        for (int i = 0; i < 26; i++) {
            numbers[i] = alphabetWeight[i];
        }
        Arrays.sort(numbers, Collections.reverseOrder());
        
        
        // 숫자 할당
        int sum = 0;
        int number = 9;
        
        for (int i = 0; i < 26; i++) {
            if (numbers[i] == 0) break;
            sum += numbers[i] * number--;
        }

        System.out.println(sum);
    }
}
