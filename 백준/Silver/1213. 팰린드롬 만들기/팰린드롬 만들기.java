import java.util.*;
import java.io.*;

class Main{


    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[26];

        for(int i=0;i<s.length();i++){

            int index = s.charAt(i) -'A';
            arr[index]++;

        }

        int odd = 0;
        int num = 0;

        for(int i=0;i<arr.length;i++){

            // 홀수개의 알파벳을 확인하는 코드
            if(arr[i]%2 !=0){
                odd++;
                num = i;// 홀수개가 가운대로 가야 되니까 num에 초기화 시켜줌.
            }

            // 홀수개의 알파벳이 두 개 이상이다면 팰린드롬을 못만듬
            if(odd>=2){
                System.out.println("I'm Sorry Hansoo");
                return ;
            }
        }

        for(int i=0;i<arr.length;i++){

            for(int j=0;j<arr[i]/2;j++){
                sb.append((char)(i+'A'));
            }
        }

        String result = sb.toString();

        // 홀수개인 알파벳 있으면 붙이기
        if(odd ==1) result +=(char)(num+'A');

        // 뒤에서부터 붙히기
        result += sb.reverse().toString();
        System.out.println(result);


    }


}
