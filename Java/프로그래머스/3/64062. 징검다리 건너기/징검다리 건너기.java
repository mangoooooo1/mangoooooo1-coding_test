class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200_2000_000;
        
        while (left < right) {
            int mid = (left + right + 1) / 2;
            
            if (canCross(stones, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    private boolean canCross(int[] stones, int k, int n) {
        int zeroCount = 0;
        
        for (int stone : stones) {
            if (stone - (n - 1) <= 0) {
                zeroCount++;
                if (zeroCount >= k) return false;
            } else {
                zeroCount = 0;
            }
        }
        return true;
    }
}