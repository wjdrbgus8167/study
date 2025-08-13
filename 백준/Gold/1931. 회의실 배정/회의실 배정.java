import java.awt.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Meeting_time{
    int start,end;

    public Meeting_time(int start,int end){
        this.start = start;
        this.end = end;

    }

}
public class Main{

    static int N;
    static Point meeting[];
    static int max_meeting_cnt;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        meeting = new Point[N];

        max_meeting_cnt=0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            meeting[i] = new Point(x,y);
        }

        Arrays.sort(meeting,(o1,o2)->{
            if(o1.y == o2.y){
                return Integer.compare(o1.x,o2.x);
            }
            return Integer.compare(o1.y,o2.y);
        });
        
        int lastEnd =-1;

        for(Point p : meeting){
            if(p.x>=lastEnd){
                max_meeting_cnt++;
                lastEnd = p.y;
            }
        }

        System.out.println(max_meeting_cnt);
    }

}