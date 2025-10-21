import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args)throws IOException{

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];

        for(int i=0;i<3;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

       
        st= new StringTokenizer(br.readLine());

        String s = st.nextToken();

        for(int i=0;i<3;i++){

            if(s.charAt(i) =='C'){
                sb.append(arr[2]+" ");
            }else if(s.charAt(i) =='B'){
                sb.append(arr[1]+" ");

            } else if(s.charAt(i) =='A'){
                sb.append(arr[0]+" ");
            }

        }

        System.out.println(sb);


    }
}