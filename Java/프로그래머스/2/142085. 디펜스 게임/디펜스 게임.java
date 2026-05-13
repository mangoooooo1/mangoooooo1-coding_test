import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i  < enemy.length; i++) {
            minHeap.offer(enemy[i]);
            
            if (minHeap.size() > k) {
                n -= minHeap.poll();
                if (n < 0) return i;
            }
        }
        return enemy.length;
    }
}