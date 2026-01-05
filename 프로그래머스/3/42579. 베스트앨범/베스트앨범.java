import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
       
        
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], 
                genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
        }
        
       
        List<String> sortedGenres = genrePlayCount.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (String genre : sortedGenres) {
           
            PriorityQueue<int[]> songs = new PriorityQueue<>((o1,o2)->{
                if(o2[1] !=o1[1]) return o2[1] -o1[1];
                
                return o1[0]-o2[0];
            });
            
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genre)) {
                    songs.add(new int[]{i, plays[i]});
                }
            }
            
            int count=0;
            
            while(!songs.isEmpty()&&count<2) {
                int[] song = songs.poll();
                answer.add(song[0]);
                count++;
            }
        }
        
       
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
