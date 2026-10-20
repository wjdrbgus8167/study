import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
          ArrayList<Integer> list = new ArrayList<>();

        String[] t = today.split("\\.");

        int todayDays = Integer.parseInt(t[0]) * 12 * 28
                      + Integer.parseInt(t[1]) * 28
                      + Integer.parseInt(t[2]);

        HashMap<String, Integer> map = new HashMap<>();

        for (String term : terms) {
            String[] temp = term.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]));
        }

        for (int i = 0; i < privacies.length; i++) {

            String[] privacy = privacies[i].split(" ");
            String[] date = privacy[0].split("\\.");

            int privacyDays = Integer.parseInt(date[0]) * 12 * 28
                            + Integer.parseInt(date[1]) * 28
                            + Integer.parseInt(date[2]);

            int months = map.get(privacy[1]);

            if (privacyDays + months * 28 <= todayDays) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();

        
    }
}