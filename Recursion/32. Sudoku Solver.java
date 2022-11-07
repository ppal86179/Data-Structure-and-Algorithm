class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    boolean helper(char[][] board)
    {
        for(int row=0; row<board.length; row++)
        {
            for(int col=0; col<board.length; col++)
            {
              //check for an empty cell
                if(board[row][col]=='.')
                {
                  //try every value from 1 to 9 
                    for(int val=1; val<=9; val++)
                    {
                      //check that value before inserting into board it is suitable or not by satisfying all three conditions
                        if(isSafe(row,col,(char)(val+'0'),board))
                        {
                          //if value if safe to enter at that position insert it into board
                            char c = (char)(val+'0');
                            board[row][col] = c;
                          
                          //and again call recursion for remaining cell
                            boolean temp = helper(board);
                            if(temp)   //if recursion will give ans true we can assume that we found one possible way of filling and we simply return true
                                return true;
                            else{   // else try another value by backtracking means change that cell again to empty cell
                                board[row][col] = '.';
                            }
                        }
                    }
                  //if we reached here means we tried all value from 1 to 9 at that cell but no one satisfying the all the three conditions it means current
                  //state of board is wrong we have to backtrack to change it's previous state so return false
                  //that mean temp will store false and it goes to backtracking step
                       return false;
                }
            }
        }
      //if we reached here means our board if filled return true
        return true;
    }
    boolean isSafe(int row,int col,char val,char[][] board)
    {
        for(int i=0; i<board.length; i++)
        {
          //check row
            if(board[row][i]==val)
                return false;
          
          //check column
            if(board[i][col]==val)
                return false;
          
          //check 3*3 matrix
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==val)
                return false;
        }
        return true;
    }
}
T.C :- O(9^m*n), 9 possible numbers for m*n cells
