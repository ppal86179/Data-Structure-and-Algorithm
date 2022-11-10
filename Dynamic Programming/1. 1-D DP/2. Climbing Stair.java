class Solution {
    public int climbStairs(int n) {
    //Recursion
        //if(n==1)return 1;
        //if(n==0)return 1;                   // stand at 0th stair
          //return climbStairs(n-1) + climbStairs(n-2);
        
    //Memoization
        //  int dp[] = new int[n+1];
        //  for(int i=0; i<n+1; i++)
        //      dp[i]=-1;
        // return memo(n,dp);
    //Dp
        return dp(n);
    }
    public int memo(int n, int dp[]){
        if(n==1)return 1;
        if(n==0)return 1;
        if(dp[n]!=-1)return dp[n];
        
        dp[n] = memo(n-1,dp) + memo(n-2,dp);
        return dp[n];
    }
    public int dp(int n){
       int dp[] = new int[n+1]; 
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2; i<n+1; i++)
            dp[i]=dp[i-1]+dp[i-2];
        
        return dp[n];
    }
}
