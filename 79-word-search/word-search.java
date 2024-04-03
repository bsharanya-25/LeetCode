class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;

        int rows = board.length;
        int cols = board[0].length;

        // Iterate through each cell in the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the current cell matches the first character of the word, start DFS
                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false; // If the word is not found in any cell
    }

    // Depth-first search (DFS) to traverse the board
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        // If all characters in the word are found, return true
        if (index == word.length())
            return true;
            int rows = board.length;
        int cols = board[0].length;

        // If the current cell is out of bounds or doesn't match the current character of the word, return false
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(index))
            return false;

        char temp = board[i][j];
        board[i][j] = '*'; // Mark the current cell as visited

        // Explore adjacent cells recursively to find the next character of the word
        boolean found = dfs(board, i + 1, j, word, index + 1) ||
                        dfs(board, i - 1, j, word, index + 1) ||
                        dfs(board, i, j + 1, word, index + 1) ||
                        dfs(board, i, j - 1, word, index + 1);

        board[i][j] = temp; // Restore the original value of the current cell
        return found;


    }
}