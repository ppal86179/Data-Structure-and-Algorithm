```
class Solution {
    public boolean exist(char[][] board, String word) {
	
	//finding first character of given word in given matrix 
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
			//if first character found then we call recursion for remaining task else return false
                if(board[i][j]==word.charAt(0)){
                 if(helper(board,word,0,i,j,board.length,board[0].length))
                     return true;
                }
            }
        }
       return false;
    }
    boolean helper(char[][] board, String word,int index,int i,int j, int rowLen,int colLen)
    {
    
        if(index==word.length())
        return true;
        
        if(i<0 || j<0 || i == rowLen || j == colLen || board[i][j] != word.charAt(index))
            return false;
        
		// mark that character cell so that we can't revisit that cell to avoid infinity calls
            char temp = board[i][j];
            board[i][j] = '#';
            boolean ans1 = helper(board,word,index+1,i,j+1,rowLen,colLen);
            boolean ans2 = helper(board,word,index+1,i+1,j,rowLen,colLen);
            boolean ans3 = helper(board,word,index+1,i-1,j,rowLen,colLen);
            boolean ans4 = helper(board,word,index+1,i,j-1,rowLen,colLen);
            board[i][j] = temp;
            return ans1 || ans2 || ans3 || ans4;
        
    
    }
}
T.C :- O(m * n), m and n are the numbe rof row and column , at max for finding word we have to traverse whole matrix cell
```
