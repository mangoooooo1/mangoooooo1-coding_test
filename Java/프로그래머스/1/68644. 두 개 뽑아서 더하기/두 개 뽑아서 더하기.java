import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
    ArrayList<Integer> list = new ArrayList<>(); 
    for(int i=0; i<numbers.length-1; i++){
        int s = numbers[i];
        for(int j=i+1; j<numbers.length; j++){
            list.add(s+numbers[j]);
        }
    }
    int[] answer = list.stream().distinct().mapToInt(Integer::intValue).toArray();
    Arrays.sort(answer);
    return answer;
    }
}
