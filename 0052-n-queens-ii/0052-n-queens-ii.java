class Solution {
    private int totalSolutions = 0;
    public int totalNQueens(int n) {
        int[] queens = new int[n]; 
        solveNQueens(queens, 0);
        return totalSolutions;
    }
    
    private void solveNQueens(int[] queens, int row) {
        if (row == queens.length) {
            totalSolutions++;
            return;
        }
        
        for (int col = 0; col < queens.length; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                solveNQueens(queens, row + 1);
            }
        }
    }
    
    private boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}




