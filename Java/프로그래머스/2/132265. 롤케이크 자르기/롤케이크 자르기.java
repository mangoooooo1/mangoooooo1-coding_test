import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> left  = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }

        int answer = 0;

        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];

            left.put(t, left.getOrDefault(t, 0) + 1);

            right.put(t, right.get(t) - 1);
            if (right.get(t) == 0) right.remove(t);

            if (left.size() == right.size()) answer++;
        }

        return answer;
    }
}