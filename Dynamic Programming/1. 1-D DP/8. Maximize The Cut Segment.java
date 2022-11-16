class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
    //1.Recursion    
        // int ans = help(n,x,y,z);
        // if(ans<0)return 0;
        // return ans;
        
    //2.Memoization 
    // int dp[] = new int[n+1];
    // for(int i=0; i<n+1; i++)
    //   dp[i]=-1;
    // int ans = Memo(n,x,y,z,dp);
    // if(ans<0)return 0;
    // return ans;
    
    //3.Tabulation
    int ans = DP(n,x,y,z);
        if(ans<0)return 0;
    return ans;
    }
    public int help(int n, int x, int y, int z){
        if(n==0)return 0;
        if(n<0)return Integer.MIN_VALUE;
        
        int op1 = help(n-x,x,y,z)+1;
        int op2 = help(n-y,x,y,z)+1;
        int op3 = help(n-z,x,y,z)+1;
        
        return Math.max(op1, Math.max(op2,op3));
    }
    public int Memo(int n, int x, int y, int z, int dp[]){
        if(n==0)return 0;
        if(n<0)return Integer.MIN_VALUE;
        if(dp[n]!=-1)return dp[n];
        
        int op1 = Memo(n-x,x,y,z,dp)+1;
        int op2 = Memo(n-y,x,y,z,dp)+1;
        int op3 = Memo(n-z,x,y,z,dp)+1;
        
        return dp[n] = Math.max(op1, Math.max(op2,op3));
    }
    public int DP(int n,int x, int y, int z){
        int dp[] = new int[n+1];
        dp[0]=0;
        
        int op1 = Integer.MIN_VALUE,op2 = Integer.MIN_VALUE,op3 = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++){
            
            if(i-x>=0) op1 = dp[i-x]+1;
            if(i-y>=0) op2 = dp[i-y]+1;
            if(i-z>=0) op3 = dp[i-z]+1;
            
            dp[i] = Math.max(op1, Math.max(op2,op3));
        }
        return dp[n];
    }
}
