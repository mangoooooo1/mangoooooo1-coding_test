class Solution {
    public int solution(int[] array) {

        int[] count = new int[1000];

        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        int max = 0;
        int answer = -1;

        for (int i = 0; i < count.length; i++) {

            if (count[i] > max) {
                max = count[i];
                answer = i;
            }

            else if (count[i] == max && max != 0) {
                answer = -1;
            }
        }

        return answer;
    }
}