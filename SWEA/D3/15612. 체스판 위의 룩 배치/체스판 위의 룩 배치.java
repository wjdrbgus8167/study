import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static StringBuilder sb = new StringBuilder();
    public static char arr[][] = new char[8][8];
    public static boolean visited[] = new boolean[8];
    public static boolean valid = true;
    public static int count2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            arr = new char[8][8];
            visited = new boolean[8];
            count2 = 0;
            valid = true; 
            for (int j = 0; j < 8; j++) {
                String s = br.readLine();
                for (int k = 0; k < 8; k++) {
                    arr[j][k] = s.charAt(k);
                }
                dfs(j);
            }
            
            if (count2 == 8 && valid) { 
            	sb.append("#" + i + " " + "yes").append("\n");
            } else {
                sb.append("#" + i + " " + "no").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int x) {
        
    	int count = 0;
       
        for (int j = 0; j < 8; j++) {
            
        	if (arr[x][j] == 'O' && visited[j]) 
        	{
                valid = false;
                return;
            }
            if (arr[x][j] == 'O' && !visited[j]) 
            { 
                count++;
                count2++;
                visited[j] = true;
            }
            if (count > 1) { // 룩이 2개 이상이면 바로 종료
                valid = false;
                return;
            }
        }
    }
}
