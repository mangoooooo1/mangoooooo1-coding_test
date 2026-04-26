import java.util.*;

class Solution {
    
    static int n;
    static boolean[][] visited;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        
        List<List<int[]>> blanks = new ArrayList<>();
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    blanks.add(bfs(i, j, game_board, 0));
                }
            }
        }
        
        List<List<int[]>> blocks = new ArrayList<>();
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1 && !visited[i][j]) {
                    blocks.add(bfs(i, j, table, 1));
                }
            }
        }
        
        int answer = 0;
        boolean[] used = new boolean[blocks.size()];
        
        // 3️⃣ 빈칸 하나씩 맞춰보기
        for (List<int[]> blank : blanks) {
            
            for (int i = 0; i < blocks.size(); i++) {
                if (used[i]) continue;
                
                List<int[]> block = blocks.get(i);
                
                if (blank.size() != block.size()) continue;
                
                for (int r = 0; r < 4; r++) {
                    block = rotate(block);
                    
                    if (match(blank, block)) {
                        used[i] = true;
                        answer += blank.size();
                        break;
                    }
                }
                
                if (used[i]) break;
            }
        }
        
        return answer;
    }
    
    private List<int[]> bfs(int x, int y, int[][] board, int target) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        list.add(new int[]{0, 0}); 
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                
                if (!visited[nx][ny] && board[nx][ny] == target) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    
                    list.add(new int[]{nx - x, ny - y});
                }
            }
        }
        
        return list;
    }
    private List<int[]> rotate(List<int[]> block) {
        List<int[]> rotated = new ArrayList<>();
        
        for (int[] p : block) {
            rotated.add(new int[]{p[1], -p[0]});
        }
        
        return normalize(rotated);
    }
    
    private List<int[]> normalize(List<int[]> list) {
        list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int ox = list.get(0)[0];
        int oy = list.get(0)[1];
        
        List<int[]> result = new ArrayList<>();
        for (int[] p : list) {
            result.add(new int[]{p[0] - ox, p[1] - oy});
        }
        
        return result;
    }
    
    private boolean match(List<int[]> a, List<int[]> b) {
        a = normalize(a);
        b = normalize(b);
        
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) {
                return false;
            }
        }
        return true;
    }
}