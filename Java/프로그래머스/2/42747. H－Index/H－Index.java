import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            if (citations[n - 1 - i] >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }
}