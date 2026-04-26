import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean exists = false;
        for (String word : words) {
            if (word.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;

        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(begin);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return level;
                }

                for (int j = 0; j < words.length; j++) {
                    if (!visited[j] && isOneDiff(current, words[j])) {
                        visited[j] = true;
                        queue.offer(words[j]);
                    }
                }
            }
            level++;
        }

        return 0;
    }

    private boolean isOneDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
}