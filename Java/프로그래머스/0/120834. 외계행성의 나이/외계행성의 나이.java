import java.util.*;

class Solution {
    public String solution(int age) {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        char[] ages = (age+"").toCharArray();
        String answer = "";

        for(int i = 0; i < ages.length; i++){
            answer+=alphabet[ages[i]-'0'];
        }
        return answer;
    }
}