import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        for (int [] wire : wires) {
            visited = new boolean[n + 1];
            
            int count = dfs(wire[0], wire);
            
            int other = n - count;
            int diff = Math.abs(count - other);
            answer = Math.min(answer, diff);
        }
        return answer;
    }
    
    private int dfs(int node, int[] cutWire) {
        visited[node] = true;
        int count = 1;
        
        for(int next : graph[node]) {
            if ((node == cutWire[0] && next == cutWire[1]) || (node == cutWire[1] && next == cutWire[0])) {
                continue;
            }
            if (!visited[next]) {
                count += dfs(next, cutWire);
            }
        }
        return count;
    }
}