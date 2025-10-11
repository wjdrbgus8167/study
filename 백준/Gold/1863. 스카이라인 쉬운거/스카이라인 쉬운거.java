import java.io.*;
import java.util.*;


class Main{


    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st ;
        int answer = 0;

        // 이전 높이와의 상태비교 -> stack
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

           // 스택이 비지 않았고, 가장 마지막에 들어온 값보다 y가 클 때,
            // 건물 하나를 추가해주고, stack에서 pop을 한다.
            // 높이가 낮아졌을 때를 의미, 곧 건물이 하나 더 있다는 뜻,

            while(!stack.isEmpty()&&stack.peek()>b){
                answer++;
                stack.pop();
            }

            if(!stack.isEmpty()&&stack.peek()==b){
                continue;
            }
            stack.push(b);
        }

        while(!stack.isEmpty()){

            if(stack.peek()>0){
                answer++;
            }
            stack.pop();
        }

        System.out.println(answer);




    }
}