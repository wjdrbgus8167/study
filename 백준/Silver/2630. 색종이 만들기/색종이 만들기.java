import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static int[][] paper;
    static int blue_paper;
    static int white_paper;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        blue_paper = 0;
        white_paper = 0;
        StringTokenizer st ;

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        divide(0,0,N);

        System.out.println(white_paper);
        System.out.println(blue_paper);
    }

    public static void divide(int r,int c, int size){

        if(checking_paper(r,c,size)){
            
            if(paper[r][c]==0){
                white_paper++;
            }else{
                blue_paper++;
            }
            return;
        }
        int half = size/2;

        divide(r,c,half);
        divide(r,c+half,half);
        divide(r+half,c,half);
        divide(r+half,c+half,half);

    }

    public static boolean checking_paper(int r,int c,int size){

        int color = paper[r][c];

       for(int i=r;i<r+size;i++){

           for(int j=c;j<c+size;j++){

               if(color !=paper[i][j]) return false;
           }
       }

        return true;
    }
}
