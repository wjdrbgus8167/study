import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int intersection = 0;
        int union = 0;


        HashMap<String,Integer> a = new HashMap<>();

        HashMap<String,Integer> b = new HashMap<>();

        for(int i=0;i<str1.length()-1;i++){
            String s = str1.substring(i,i+2).toLowerCase();

            if(s.charAt(0)<'a'||s.charAt(0)>'z'|| s.charAt(1)<'a'||s.charAt(1)>'z') continue;


            union++;
            a.put(s,a.getOrDefault(s,0)+1);

        }

        for(int i=0;i<str2.length()-1;i++){

            String s = str2.substring(i,i+2).toLowerCase();

            if(s.charAt(0)<'a'||s.charAt(0)>'z'|| s.charAt(1)<'a'||s.charAt(1)>'z') continue;

            union ++;
            b.put(s,b.getOrDefault(s,0)+1);
        }


        for(Map.Entry<String,Integer> e : a.entrySet()){

            String k = e.getKey();
            int v = e.getValue();

            for(Map.Entry<String,Integer> e1 : b.entrySet()){

                String k1 = e1.getKey();
                int v1 = e1.getValue();


                if(k.equals(k1)){

                    intersection += Math.min(v,v1);
                    break;
                }

            }
        }

        
        union -=intersection;
        if(union==0) return 65536;
        
        double cal = (double)intersection/union;



        return answer = (int)(cal*65536);
    }
}