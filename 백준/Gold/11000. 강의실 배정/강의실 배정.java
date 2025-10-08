import java.util.*;
import java.io.*;

class Time{

    int start, end;

    public Time(int start, int end){
        this.start =start;
        this.end = end;

    }
}
class Main{


    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Time> room =new PriorityQueue<>((o1,o2)->{
            if(o1.start==o2.start) return o1.end - o2.end;

            return o1.start-o2.start;
        });

        StringTokenizer st ;

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            room.add(new Time(start,end));
        }

        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        endTime.add(room.poll().end);

        while(!room.isEmpty()){
            Time time = room.poll();

            if(endTime.peek()<=time.start){
                endTime.poll();
            }
            endTime.add(time.end);
        }

        System.out.println(endTime.size());

    }


}
