class Solution {
    public String solution(String rsp) {
        String[] rspArr = rsp.split("");
        String answer = "";
        
        for(String s : rspArr){
            switch (s) {
                case "0":
                    answer+="5";
                    break;
                case "2": 
                    answer+="0";
                    break;
                case "5": 
                    answer+="2";
                    break;
            }
        }
        return answer;
    }
}