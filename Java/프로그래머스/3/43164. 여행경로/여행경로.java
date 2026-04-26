import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> result;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        dfs("ICN", "ICN", tickets, 0);
        
        return result.toArray(new String[0]);
    }
    
    private boolean dfs(String current, String path, String[][] tickets, int count) {
        if (count == tickets.length) {
            result = new ArrayList<>(Arrays.asList(path.split(" ")));
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                
                if (dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count + 1)) {
                    return true;
                }
                
                visited[i] = false; 
            }
        }
        return false;
    }
}