class Solution {
    public int solution(int n) {
        int a = n;
        int b = 6;
        while ( b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return ((n*6)/a)/6;
    }
}