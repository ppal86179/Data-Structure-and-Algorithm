class Solution {
    public int fib(int n) {
        //recursion
        // if(n==1 || n==0)return n;        
        // return fib(n-1) + fib(n-2);
        
        //Top-down :- memoization
        // int dp[] = new int[n+1];
        // for(int i=0; i<n+1; i++)
        //     dp[i]=-1;
        // return memo(n,dp);
        
        //Bottom-up :- dp
        return dp(n);
    }
    public int memo(int n, int dp[]){
        if(n==1 || n==0)return n;
        if(dp[n]!=-1)return dp[n];
        dp[n]=memo(n-1,dp) + memo(n-2,dp);
        return dp[n];
    }
    public int dp(int n){
        if(n==0)return 0;
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2; i<=n; i++)
            dp[i]=dp[i-1]+dp[i-2];
        
        return dp[n];
    }
}
