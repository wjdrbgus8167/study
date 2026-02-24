import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer;


       TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i=0;i<operations.length;i++){

            String operation  = operations[i];

            Integer num = Integer.parseInt(operation.substring(2));
            String command = operation.substring(0,1);

            if(command.equals("I")){
                map.put(num,map.getOrDefault(num,0)+1);
            }else{
                if(map.isEmpty()) continue;

                if(num==1){
                    int maxKey = map.lastKey();
                    decreaseOrRemove(map,maxKey);
                }else{
                    int minKey = map.firstKey();
                    decreaseOrRemove(map,minKey);
                }
            }


        }

        if(map.isEmpty()) return new int[]{0,0};

        return answer = new int[]{map.lastKey(),map.firstKey()};
    }
    
     private void decreaseOrRemove(TreeMap<Integer,Integer> map, int key){
        int count = map.get(key);

        if(count==1) map.remove(key);
        else map.put(key,count-1);
    }
}