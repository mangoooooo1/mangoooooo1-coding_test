import java.util.Arrays;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 20_000_000;
        int[][] dist = new int[n + 1][n + 1];
        
        for (int[] row : dist) Arrays.fill(row, INF);
        for (int i = 1; i <= n; i++) dist[i][i] = 0;
        
        for (int[] fare : fares) {
            int c = fare[0], d = fare[1], f =fare[2];
            dist[c][d] = f;
            dist[d][c] = f;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int answer = INF;
        for (int k = 1; k <= n; k++) {
            int total = dist[s][k] + dist[k][a] + dist[k][b];
            answer = Math.min(answer, total);
        }
        
        return answer;
    }
}