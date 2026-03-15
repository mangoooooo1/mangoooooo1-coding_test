class Solution {
    public int solution(int hp) {
        int answer = 0;
        answer+=hp/5;
        hp=hp%5;
        if (hp < 3) {
            answer+=hp;
        } else {
            answer+=hp/3;
            answer+=hp%3;
        }
        return answer;
    }
}