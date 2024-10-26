

import java.io.*;
import java.util.*;

public class Main{

	static int L,C;
	static ArrayList<Character> list;
	static boolean visited[];
	static StringBuilder sb ;
	static ArrayList<String> result;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		// 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a,e,i,o,u)과 최소 두 개의 
		// 자음으로 구성되어 있다. 
		// 암호의 문자들을 증가하는 순서로 구성 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		list = new ArrayList<>();
		result = new ArrayList<>();
		visited=  new boolean[C];
		for(int i=0;i<C;i++) {
			
			String word = st.nextToken();
			list.add(word.charAt(0));
			
		}
		
		Collections.sort(list);
		
		dfs(0,0,0,0);
		for(String s : result) {
			System.out.println(s);
		}
		
	}
	
	public static void dfs(int start, int cnt,int vowels,int consonants) {
		
		if(cnt==L) {
			sb = new StringBuilder();
			if(vowels>=1&& consonants>=2) {
				for(int i=0;i<C;i++) {
					if(visited[i]) {
						
						sb.append(list.get(i));
					}
				}
				if(sb.toString()!=" ") {
					result.add(sb.toString());
				}
			}
			
			
			return;
		}
		
		
		
		for(int i=start;i<C;i++) {
			
			if(!visited[i]) {
				
				visited[i]=true;
				
				if(isVowel(list.get(i))) {
					dfs(i+1,cnt+1,vowels+1,consonants);
				}else {
					dfs(i+1,cnt+1,vowels,consonants+1);
				}
				
				
				visited[i]=false;
			}
			
		}
		
	}
	
	private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
