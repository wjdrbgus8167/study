import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 
        int[] sizes = new int[6]; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken()); 
        }

        st      = new StringTokenizer(br.readLine());
        int T   = Integer.parseInt(st.nextToken()); 
        int P   = Integer.parseInt(st.nextToken()); 

        int tCnt = 0; 
        
        for(int j = 0 ; j < sizes.length; j++) {
            tCnt += sizes[j] / T;
            if(sizes[j] % T > 0) {tCnt += 1;} 
        }

        System.out.println(tCnt);
        System.out.println(N/P + " " + N%P);
    }
}