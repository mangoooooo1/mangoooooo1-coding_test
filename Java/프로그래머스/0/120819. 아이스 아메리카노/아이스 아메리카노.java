class Solution {
    public int[] solution(int money) {
        int coffee = money/5500;
        int rest = money - coffee*5500;
        int [] answer = {coffee, rest};
        return answer;
    }
}