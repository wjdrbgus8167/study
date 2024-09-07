

import java.io.*;
import java.util.*;

public class Solution {

	static int N,K;
	static ArrayList<Character> words;
	static ArrayList<String> list;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		
		for(int tc=1;tc<=t;tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			String s = br.readLine();
			words = new ArrayList<>();
			list = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				words.add(s.charAt(i));
			}
			
			for(int i=0;i<N/4;i++) {
				char lastCh = words.get(words.size()-1);
				for(int j=0;j<N;j=j+N/4) {
					String word = null;
					for(int k=j;k<j+N/4;k++) {
						word +=words.get(k);
					}
					word = word.substring(4);
					if(!list.contains(word)) {
						list.add(word);
					}
				}
				words.add(0,lastCh);
				words.remove(words.size()-1);
			}
			Collections.sort(list,Collections.reverseOrder());
			
			String word = list.get(K-1);
			double result =0;
			for(int i=0;i<word.length();i++) {
				char num = word.charAt(i);
				
				if(num>='A') {
					result += ((num-65)+10)*Math.pow(16,word.length()-i-1); 
				}else {
					result += (num-48)*Math.pow(16,word.length()-i-1);
				}
			}
			
			sb.append("#"+tc+" "+Math.round(result)+"\n");
		}
		System.out.println(sb);
		
		
	}

}
