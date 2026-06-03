import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> cache = new LinkedList<>();
        int time = 0;
        
        for (String city : cities) {
            String c = city.toLowerCase();
            
            if (cacheSize == 0) {
                time += 5;
                continue;
            }
            
            if (cache.contains(c)){
                cache.remove(c);
                cache.addFirst(c);
                time += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.removeLast();
                }
                cache.addFirst(c);
                time += 5;
            }
        }
        return time;
    }
}