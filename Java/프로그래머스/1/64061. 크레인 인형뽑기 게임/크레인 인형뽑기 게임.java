import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>(); 
        
        for(int i = 0; i < moves.length; i++) {
            int n = moves[i] - 1;
            for(int j = 0; j < board.length; j++){
                if (board[j][n] != 0) {
                    int doll = board[j][n];
                    board[j][n] = 0;
                    if(!stack.isEmpty() && doll == stack.peek()) {
                        stack.pop();
                        answer+=2;
                    } else {
                        stack.push(doll);
                    }         
                    break;
                }
            }
        }
        return answer;
    }
}