import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] sorted = emergency.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer> map = new HashMap<>();

        int rank = 1;
        for(int i = sorted.length - 1; i >= 0; i--){
            map.put(sorted[i], rank++);
        }

        int[] answer = new int[emergency.length];
        for(int i = 0; i < emergency.length; i++){
            answer[i] = map.get(emergency[i]);
        }

        return answer;
        }
    }