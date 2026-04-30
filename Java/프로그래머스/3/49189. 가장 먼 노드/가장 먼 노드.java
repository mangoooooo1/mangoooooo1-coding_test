import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++ ){
            graph.add(new ArrayList<>());
        }
        
        for (int [] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.add(next);;
                }
            }
        }
        
        int maxDist = 0;
        for (int i = 0; i <= n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) count++;
        }
        return count;
    }
}