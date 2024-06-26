import java.io.*;
import java.util.*;

class Solution {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int t = Integer.parseInt(br.readLine());
       
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int testcase = 1; testcase <=t; testcase++) {
           
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int num=0;
            if (s.charAt(0) == 'o') {
                num = 0;
            } else if (s.charAt(1) == 'o') {
                num = 1;
            } else {
                num = 2;
            }
            
            while (k > 0) {
                switch (num) {
                    case 0:
                        num = 1;
                        break;
                    case 1:
                        num = 0;
                        break;
                    case 2:
                        num = 1;
                        break;
                }
                k--;
            }
           sb.append("#"+testcase+" "+num).append("\n");
            
        }
       
        System.out.println(sb);
    }
}
