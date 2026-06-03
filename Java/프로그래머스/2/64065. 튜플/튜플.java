import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2); 
        String[] sets = s.split("},");    

        for (int i = 0; i < sets.length; i++) {
            sets[i] = sets[i].replace("{", "").replace("}", "");
        }

        Arrays.sort(sets, (a, b) -> a.length() - b.length());

        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (String set : sets) {
            for (String numStr : set.split(",")) {
                int num = Integer.parseInt(numStr);
                if (!visited.contains(num)) {
                    visited.add(num);
                    result.add(num);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}