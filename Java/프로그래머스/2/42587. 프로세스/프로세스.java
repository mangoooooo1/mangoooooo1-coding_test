import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }

        int[] sorted = priorities.clone();
        Arrays.sort(sorted);
        int ptr = sorted.length - 1; // 가장 높은 우선순위 포인터

        int answer = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == sorted[ptr]) {
                answer++;
                ptr--;
                if (cur[1] == location) return answer;
            } else {
                queue.offer(cur);
            }
        }

        return answer;
    }
}