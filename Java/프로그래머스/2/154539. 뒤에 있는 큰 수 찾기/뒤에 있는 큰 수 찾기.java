import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && numbers[deque.peekFirst()] < numbers[i]) {
                answer[deque.removeFirst()] = numbers[i];
            }
            deque.addFirst(i);
        }
        return answer;
    }
}