class Solution {
    public String solution(String p) {
        String answer = "";
        
        if(p.isEmpty()) return "";
        
        
        int balance = 0;
        int idx = 0;
        
        for(int i=0;i<p.length();i++){
            balance += (p.charAt(i)=='(') ? 1:-1;
            
            if(balance == 0){
                idx =i+1;
                break;
            }
        }
        
        String u = p.substring(0,idx);
        String v = p.substring(idx);
        
        if(u.charAt(0)=='('){
            return u+solution(v);
        }
        
        StringBuilder sb=  new StringBuilder();
        sb.append('(');
        sb.append(solution(v));
        sb.append(')');
        
        for(int i=1;i<u.length()-1;i++){
            sb.append(u.charAt(i)=='('?')':'(');
        }
        
        return sb.toString();
       
    }
}