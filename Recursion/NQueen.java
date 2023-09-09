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


/*
------------------------Solution 2: Optimised--------------------------------

Intuition: This is the optimization of the issafe function. 
In the previous issafe function, we need o(N) for a row, o(N) for the column, and o(N) for the diagonal. 
Here, we will use hashing to maintain a list to check whether that position can be the right one or not.
*/

class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        
        int leftRow[] = new int[n];
        int uppDiag[] = new int[2 * n - 1];
        int lowDiag[] = new int[2 * n - 1];
        placeQueens(0, board, leftRow, lowDiag, uppDiag, res);
        return res;

    }

    private void placeQueens(int col, char[][] board, int[] leftRow, int[] lowDiag, int[] uppDiag, List<List<String>> res) {
        if (col == board.length) {
            res.add(constructList(board));
            return;
        }

        for(int row=0;row<board.length;row++) {
            if (leftRow[row] == 0 && lowDiag[row + col] == 0 && uppDiag[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowDiag[row + col] = 1;
                uppDiag[board.length - 1 + col - row] = 1;
                placeQueens(col + 1, board, leftRow, lowDiag, uppDiag, res);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowDiag[row + col] = 0;
                uppDiag[board.length - 1 + col - row] = 0;
            }
        }
    }

    private List<String> constructList(char[][] board) {
        List <String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}