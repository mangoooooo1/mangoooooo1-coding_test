import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        for(String r:record) {
            String[] rr = r.split(" ");
            if(!rr[0].equals("Leave")) {
                map.put(rr[1], rr[2]);
            }
        }
        
        ArrayList<String> answer = new ArrayList<>(); 
        for(String r:record) {
            String[] rr = r.split(" ");
            String nickname = map.get(rr[1]);
            if(rr[0].equals("Enter")) {
                answer.add(nickname+"님이 들어왔습니다.");
            } else if(rr[0].equals("Leave")) {
                answer.add(nickname+"님이 나갔습니다.");
            }
        }
        return answer.toArray(new String[0]); 
    }
}