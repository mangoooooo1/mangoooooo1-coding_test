import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(charArr[i] == '('){
                stack.push('(');
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char pop = stack.pop();
                answer = (pop == '(') ? true : false;
            }
        }
        if (!stack.isEmpty()){
                return false;
        }
        return answer;
    }
}