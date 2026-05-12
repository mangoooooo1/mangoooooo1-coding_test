import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        
        Set<Integer> resultSet = new HashSet<>();
        
        int[] doubled = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            doubled[i] = elements[i % n]; 
        }
        
        for (int length = 1; length <= n; length++) {
            
            for (int start = 0; start < n; start++) {
                
                int sum = 0;
                for (int k = start; k < start + length; k++) {
                    sum += doubled[k];
                }
                
                resultSet.add(sum);
            }
        }
        
        return resultSet.size();
    }
}