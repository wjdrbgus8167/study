import java.io.*;
import java.util.*;

class Country implements Comparable<Country>{

    int num,gold,silver,bronze,rate;

    public Country(int num,int gold,int silver,int bronze,int rate){
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rate = rate;
    }

    public int compareTo(Country o){

        if(this.gold ==o.gold){

            if(this.silver==o.silver){
                return o.bronze -bronze;
            }else{
                return o.silver - silver;

            }
        }else{
            return o.gold -gold;
        }

    }

}
class Main{

    static int N;
    static int country;
    static ArrayList<Country> list;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        country = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for(int i=0;i<N;i++){

            st=  new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            list.add(new Country(num,gold,silver,bronze,0));

        }

        Collections.sort(list);

        list.get(0).rate =1;

        int result = 0;

        for(int i=1;i<list.size();i++){

            int before_gold = list.get(i-1).gold;
            int before_silver = list.get(i-1).silver;
            int before_bronze = list.get(i-1).bronze;

            Country now = list.get(i);

            // 목표로 한 국가가 나왔을 때 인덱스 저장
            if(list.get(i).num==country){
                result = i;
            }

            // 만약 메달의 개수가 모두 같은 공동 순위의 경우
            if(now.gold == before_gold&&now.silver == before_silver&&now.bronze == before_bronze){
                // 이전 순위와 동일한 순위로 저장
                list.get(i).rate=list.get(i-1).rate;
            }else{
                // 아니라면 현재 인덱스에 +1한 값이 순위
                list.get(i).rate=i+1;
            }
        }

        System.out.println(list.get(result).rate);

    }


}