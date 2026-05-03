class Solution {
    static int answer;
    static int[] queens;
    static int n;
    
    public int solution(int n) {
        answer = 0;
        this.n = n;
        queens = new int[n];
        dfs(0);
        return answer;
    }
    
    static void dfs(int row) {
        if (row == n) {
            answer++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                queens[row] = col;
                dfs(row + 1);
            }
        }
    }
    
    static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false;
            if (Math.abs(queens[i] - col) == Math.abs(i - row)) return false;
        }
        return true;
    }
}