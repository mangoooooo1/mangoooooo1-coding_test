class Solution {
    public int solution(String word) {
        int[] counts = {781, 156, 31, 6, 1};
        String vowels = "AEIOU";
        
        int answer = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int idx = vowels.indexOf(word.charAt(i));
            answer += idx * counts[i];
            answer += 1;
        }
        return answer;
    }
}