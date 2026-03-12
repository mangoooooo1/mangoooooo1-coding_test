import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder(my_string);
        int sb_length = sb.length();
        
        String answer = "";
        for(int i=0; i<sb_length; i++){
            char s = sb.charAt(i);
            for(int j=0; j<n; j++){
                answer+=s;
            }
        }
        return answer;
    }
}