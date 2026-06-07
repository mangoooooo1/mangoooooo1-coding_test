import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {

        Map<String, Integer> mapA = buildBigramMap(str1.toLowerCase());
        Map<String, Integer> mapB = buildBigramMap(str2.toLowerCase());

        int intersection = 0;
        for (String key : mapA.keySet()) {
            if (mapB.containsKey(key)) {
                intersection += Math.min(mapA.get(key), mapB.get(key));
            }
        }

        int union = 0;
        Map<String, Integer> allKeys = new HashMap<>(mapA);
        for (Map.Entry<String, Integer> e : mapB.entrySet()) {
            allKeys.merge(e.getKey(), e.getValue(), Math::max);
        }
        for (int cnt : allKeys.values()) {
            union += cnt;
        }

        if (union == 0) return 65536;
        return (int)((double) intersection / union * 65536);
    }

    private Map<String, Integer> buildBigramMap(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);

            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String bigram = "" + c1 + c2; 
                map.put(bigram, map.getOrDefault(bigram, 0) + 1);
            }
        }
        return map;
    }
}