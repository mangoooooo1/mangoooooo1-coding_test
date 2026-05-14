import java.util.*;

class Solution {
        static int[] dx = { -1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};
        
        public int[] solution(String[] maps) {
            int rows = maps.length;
            int cols = maps[0].length();
            char[][] grid = new char[rows][cols];
            for(int i = 0; i < rows; i++) {
                grid[i] = maps[i].toCharArray();
            }
            
            List<Integer> result = new ArrayList<>();
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] != 'X') {
                        int sum = bfs(grid, i, j, rows, cols);
                        result.add(sum);
                    }
                }
            }
            if (result.isEmpty()) return new int[]{-1};
            
            Collections.sort(result);
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        
        private int bfs(char[][] grid, int startR, int startC, int rows, int cols) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startR, startC});
            
            int sum = 0;
            
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                
                if (grid[r][c] == 'X') continue;
                sum += grid[r][c] - '0';
                grid[r][c] = 'X';
                
                for (int d = 0; d < 4; d++) {
                    int nr = r + dx[d];
                    int nc = c + dy[d];
                    
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] != 'X'){
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            return sum;
        }
    }
