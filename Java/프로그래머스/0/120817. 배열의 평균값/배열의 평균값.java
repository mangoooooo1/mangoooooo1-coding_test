class Solution {
    public double solution(int[] numbers) {
        double total = 0;
        for (int i = 0; i < numbers.length; i++){
            total=total+numbers[i];
        }
        double answer = total/numbers.length;
        return answer;
    }
}