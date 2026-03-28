import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> goalQueue = new ArrayDeque<>();
        Queue<String> cards1Queue = new ArrayDeque<>();  
        Queue<String> cards2Queue = new ArrayDeque<>();  
        
        for(int i = 0; i < goal.length; i++){
            goalQueue.add(goal[i]);
        }
        for(int i = 0; i < cards1.length; i++){
            cards1Queue.add(cards1[i]);
        }
        for(int i = 0; i < cards2.length; i++){
            cards2Queue.add(cards2[i]);
        }
        
        for(int i = 0; i < goal.length; i++){
            String word = goalQueue.poll();
            if (word.equals(cards1Queue.peek())){
                cards1Queue.poll();
            } else if (word.equals(cards2Queue.peek())){
                cards2Queue.poll();
            } else {
                return "No";
            }    
        }
        return "Yes";
    }
}