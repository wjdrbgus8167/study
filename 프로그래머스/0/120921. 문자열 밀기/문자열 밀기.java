class Solution {
    public int solution(String A, String B) {
        int answer = 0;

        if(A.equals(B)) return 0;

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<A.length();i++){
            sb.append(A.charAt(i));
        }

        int length = A.length();

        for(int i=0;i<length-1;i++){

            Character c = sb.charAt(length-1);
            sb.deleteCharAt(length-1);
            sb.insert(0,c);

            System.out.println(sb.toString());

            if(B.equals(sb.toString())){
                answer++;
                return answer;

            }else{
                answer++;
            }

        }

        return -1;
    }
}