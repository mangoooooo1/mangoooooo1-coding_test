class Solution {
    public int solution(int num1, int num2) {
        int minNum = 0;
        int maxNum = 100;
        int answer = -1;
        if (minNum < num1 && num1 <= maxNum && minNum < num2 && num2 <= maxNum) {
            answer = num1 % num2;
        }
        return answer;
    }
}