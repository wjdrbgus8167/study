import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Scanner;

class Solution {
	
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <=T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            
        	int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            char[][] arr = new char[N][M];
            int[] board = new int[4]; 

            for (int i = 0; i < N; i++) {
                String row = br.readLine();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = row.charAt(j);
                    if (arr[i][j] == '#') {
                        if ((i + j) % 2 == 0) {
                            board[0]++;
                        } else {
                            board[1]++;
                        }
                    } else if (arr[i][j] == '.') {
                        if ((i + j) % 2 == 0) {
                            board[2]++;
                        } else {
                            board[3]++;
                        }
                    }
                }
            }

            String answer;
            if (board[0] > 0 && board[1] > 0 || board[2] > 0 && board[3] > 0 || board[0] > 0 && board[2] > 0 || board[1] > 0 && board[3] > 0) {
                answer = "impossible";
            } else {
                answer = "possible";
            }

            sb.append("#"+t+" "+answer).append("\n");
        }
        System.out.println(sb);
    }
}
