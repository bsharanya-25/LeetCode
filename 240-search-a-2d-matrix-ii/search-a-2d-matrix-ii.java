class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int cols = matrix[0].length-1;
        int row = 0;
    
        while (row < matrix.length && cols >= 0) {
            if (matrix[row][cols] == target) {
                return true;
            } else if (matrix[row][cols] < target) {
                row++;
            } else {
                cols--;
            }
        }                                                    
        return false;
    }
}