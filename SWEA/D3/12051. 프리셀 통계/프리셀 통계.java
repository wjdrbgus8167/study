import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            long n = sc.nextLong();
            int d = sc.nextInt();
            int g = sc.nextInt();
             
            if(d != 0 && g==0){
                System.out.println("#" + test_case + " " + "Broken");
            }else if(d != 100 && g==100){
                System.out.println("#" + test_case + " " + "Broken");
            } else {
                boolean flag = false;
                for (int i = 1; i <= n; i++) {
                    if ((i * d) / 100 == (i * d) / 100.0) { 
                        flag = true;
                        break;
                    }
                }
 
                if (flag) {
                    System.out.println("#" + test_case + " " + "Possible");
                } else {
                    System.out.println("#" + test_case + " " + "Broken");
                }
            }
        }
    }
}