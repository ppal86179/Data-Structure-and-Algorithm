class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                board[i][j] = '.';
            }
        }
        help(0,n,ans,board);
        return ans;
        
    }
    void help(int i, int n,List<List<String>> ans,char[][] board)
    {
        //BASE CASE
        if(i==n)
        {
            List<String> temp = new ArrayList<>();
            for(int j=0; j<n;j++)
            {
                String s = new String(board[j]);
                temp.add(s);
            }
            ans.add(temp);
            return;
        }
        
        //RECURSION
        for(int j=0; j<n; j++)
        {
            if(isSafe(i,j,board,n))
            {
                board[i][j] = 'Q';
                help(i+1,n,ans,board);
                board[i][j] = '.';
            }
        }
    }
    
    boolean isSafe(int i,int j,char[][] board,int n)
    {
        //up
        int tempi = i;
        while(tempi>=0)
        {
            if(board[tempi][j] == 'Q')
                return false;
            tempi--;
        }
        
        //Right Diagonal
        tempi = i;
        int tempj = j;
        while(tempi>=0 && tempj<=n-1)
         {
            if(board[tempi][tempj] == 'Q')
                return false;
            tempi--;
            tempj++;
         }
        
        //left diagonal
         tempi = i;
        tempj = j;
        while(tempi>=0 && tempj>=0)
         {
            if(board[tempi][tempj] == 'Q')
                return false;
            tempi--;
            tempj--;
         }
        return true;
    }
}
T.C :- n! * n
