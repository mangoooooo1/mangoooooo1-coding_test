import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int centerNum = array.length/2;
        int length = array.length;
        int answer = -1;
        if (length%2!=0 && 0 < length && length < 100) {
            if (-1000 > array[centerNum] && array[centerNum] > 1000 ) return answer;
            answer = array[centerNum];
        }
        return answer;
    }
}