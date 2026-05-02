class Solution {
    static int answer = 0;         
    static boolean[] visited;      
    static int[][] dungeons;
    static int n;

    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        this.dungeons = dungeons;
        visited = new boolean[n];  
        
        dfs(k, 0); 
        return answer;
    }

    static void dfs(int fatigue, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (fatigue < dungeons[i][0]) continue; 
            
            visited[i] = true;

            dfs(fatigue - dungeons[i][1], count + 1);

            visited[i] = false;
        }
    }
}