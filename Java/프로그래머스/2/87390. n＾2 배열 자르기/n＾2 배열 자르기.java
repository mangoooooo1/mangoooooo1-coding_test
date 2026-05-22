class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];

        for (long k = left; k <= right; k++) {
            long i = k / n;  // 행 (0-indexed)
            long j = k % n;  // 열 (0-indexed)
            answer[(int)(k - left)] = (int) Math.max(i, j) + 1;
        }

        return answer;
    }
}