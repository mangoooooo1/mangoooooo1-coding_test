class Solution {
    public int solution(int balls, int share) {

        long result = 1;

        for(int i=1;i<=share;i++){
            result = result * (balls - share + i) / i;
        }

        return (int)result;
    }
}