import java.io.*;
import java.util.*;

class Main {


    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n  = Integer.parseInt(br.readLine());

        for(int i=1;i<=n-1;i++){

            for(int j=0;j<i;j++){
                System.out.print("*");
            }

            for(int j=n;j>i;j--){
                System.out.print(" ");
            }

            for(int j=n;j>i;j--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=n;i>=1;i--){

            for(int j=0;j<i;j++){
                System.out.print("*");
            }

            for(int j=n;j>i;j--){
                System.out.print(" ");
            }

            for(int j=n;j>i;j--){
                System.out.print(" ");
            }

            for(int j=0;j<i;j++){
                System.out.print("*");
            }

            System.out.println();
        }

    }
}
