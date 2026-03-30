import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map1.put(want[i], number[i]);
        }
        int answer = 0;
        
        for(int i = 0; i < discount.length - 9; i++){
            HashMap<String, Integer> map2 = new HashMap<>();
            for(int j = i; j < i+10; j++){
                if(map1.containsKey(discount[j])){
                    map2.put(discount[j], map2.getOrDefault(discount[j], 0) + 1);
                }
            }
            if(map2.equals(map1)){
                answer++;
            }
        }
        return answer;
    }
}