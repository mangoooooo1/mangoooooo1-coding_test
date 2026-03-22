import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> map = new HashMap<Integer, Double>();
        int total = stages.length;
        
        for(int i = 1; i <= N; i++){
            final int stage = i;
            int count = (int) Arrays.stream(stages).filter(n -> n == stage).count();
            double fail = (total == 0) ? 0 : (double) count / total;
            map.put(i, fail);
            total -= count;       
        }
        int[] answer = map.entrySet()
        .stream()
        .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
        .mapToInt(Map.Entry::getKey)
        .toArray();

        return answer;
    }
}
