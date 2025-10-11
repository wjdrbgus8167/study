import java.io.*;
import java.util.*;

/*
    1. 학생 이름 -> 가장 첫 번째 제출 이외 모두 무시 -> Set
    2. 장소
    3. 시간대

    1. 가장 많은 사람이 제출한(장소, 시간대)쌍을 선택
    2. 만약 1번에 해당하는 구간이 여러 개라면 사전 순으로 가장 앞에 오는 장소를 선택
        2.1 아스키 코드 기준
    3. 2번에서 고른 장소에 가장 많이 제출된 시간대가 여러 개라면 가장 빠른 시간대를 고름

 */
class Place implements Comparable<Place>{

   String place ;
   int start;

    public Place(String place,int start){
        this.place = place;
        this.start = start;
    }

    @Override
    public int compareTo(Place o) {
        if(!this.place.equals(o.place)){
            return this.place.compareTo(o.place); // 장소가 다르면 문자열 사전순 정렬
        }

        return Integer.compare(this.start,o.start); // 시간이 작을수록 먼저
    }

}
class Main{


    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        Set<String> name = new HashSet<>();

        //TreeMap : 정렬된 맵, 키가 자동으로 오름차순 정렬
        // 키가 Integer(시간)이므로 entrySet()을 순회하면 시간 오름차순으로 탐색
        // 가장 이른 max시간을 찾을 수 있음(처음 만나는 value==max가 곧 가장 이른 시간)
        HashMap<String,TreeMap<Integer,Integer>> map = new HashMap<>();

        int max= -1;

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            String student_name = st.nextToken();
            String place = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(name.contains(student_name)) continue;

            name.add(student_name);

            // map.computeIfAbsent : 장소 키가 없으면 새 TreeMap을 만들어 넣고 반환, 있으면 기존 맵 반환

            TreeMap<Integer,Integer> time = map.computeIfAbsent(place,s->new TreeMap<>());

            // 모든 정수 시간마다 카운트를 +1, 동시에 글로벌 최대 max 갱신
            for(int j=start;j<end;j++){
                time.put(j,time.getOrDefault(j,0)+1);
                max = Math.max(max,time.get(j));
            }

        }

        List<Place> visit = new ArrayList<>();

        for(String place : map.keySet()){

            TreeMap<Integer,Integer> time = map.get(place);

            //entrySet()은 (키,값)쌍을 한 번에 다룸
            // 키만 필요하다면 keySet(), 값만 필요하다면 values()를 씀.
            for(Map.Entry<Integer,Integer> timeEntry : time.entrySet()){

                int a = timeEntry.getKey();

                if(timeEntry.getValue() == max){
                    visit.add(new Place(place,a)); // 그 장소에서 가장 이른 amx 시간
                    break; // TreeMap이라 키(시간) 오름차순, 첫 만남이 가장 이른 시간
                }
            }

        }

        Collections.sort(visit); // Place.compareTo: 장소 사전순 -> 시간 오름차순

        Place result = visit.get(0); // 규칙 2,3을 만족하는 최솟값
        int endTime = findEnd(map.get(result.place),result.start,max);
        
        System.out.println(result.place+" "+result.start+" "+endTime);

    }

    static int findEnd(TreeMap<Integer, Integer> time, int start, int max) {

        int end = start;

        while (time.containsKey(end) && time.get(end) == max) {
            end++;
        }
        return end;
    }
}