import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        String first = sc.next();
        String second = sc.next();
        String third = sc.next();

        long value = (map.get(first) * 10 + map.get(second));
        long multiplier = (long) Math.pow(10, map.get(third));

        System.out.println(value * multiplier);
    }
}
