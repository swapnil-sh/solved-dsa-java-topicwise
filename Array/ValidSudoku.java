/*36. Valid Sudoku - Leetcode Java Solution*/


/*
------------------------Optimal Solution--------------------------

Time complexity : O(1) since all we do here is just one iteration over the board with 81 cells.
Space complexity : O(1)

*/
class ValidSudoku
{
    public boolean isValidSudoku(char[][] board) 
    {
        HashSet<String> seen=new HashSet<>();
        
        int i,j;
        char currVal=' ';
        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                currVal=board[i][j];
                if(currVal!='.')
                {
                   if(!seen.add(currVal + " present at row -> " + i) || 
                      !seen.add(currVal + " present at col -> " + j) || 
                      !seen.add(currVal + " present in subBox -> " + i/3+"-"+j/3))
                        return false;
                }
                
            }
        }
        
        return true;
    }
}