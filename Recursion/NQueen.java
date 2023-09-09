/*
51. N-Queens - Leetcode Java Solutions
https://leetcode.com/problems/n-queens/
*/

/*
------------ Brute Force Solution------------------------------

Time Complexity: Exponential in nature since we are trying out all ways, to be precise its O(N! * N)
Space Complexity: O(N^2)

*/
class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        
        placeQueens(0, board, res);
        return res;

    }

    private void placeQueens(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(constructList(board));
            return;
        }

        for(int row=0;row<board.length;row++) {
            if (validPos(row, col, board)) {
                board[row][col] = 'Q';
                placeQueens(col+1, board, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean validPos(int row, int col, char[][] board) {
        int dupRow = row;
        int dupCol = col;

        while(row>=0 && col>=0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        while(col>=0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = dupRow;
        col = dupCol;

        while(row<board.length && col>=0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    private List <String> constructList(char[][] board) {
        List <String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}