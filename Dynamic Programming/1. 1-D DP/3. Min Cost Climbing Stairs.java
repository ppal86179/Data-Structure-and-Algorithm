class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        //1. Recursion
        // return Math.min(help(cost,0,n), help(cost,1,n));
        
        //2. Memoization - Top-Down DP
        // int dp[] = new int[n+1];
        // for(int i=0; i<n+1; i++)
        //     dp[i]=-1;
        // return Math.min(helpMemo(cost,0,n,dp), helpMemo(cost,1,n,dp));
        
        //3. Tabulation - Bottom-up DP
        return dp(cost,n);
    }
    public int help(int cost[], int index, int n){
        if(index>=n) //return 0 if are at that stair or we crossed the stair
            return 0;
        
        int oneStep = help(cost,index+1,n);   // take one step
        int twoStep = help(cost,index+2,n);   // take two step
        
        return cost[index]+Math.min(oneStep,twoStep);
    }
    public int helpMemo(int cost[], int index, int n, int dp[]){
        if(index>=n)return 0;
            
        if(dp[index]!=-1)return dp[index];
        
        int oneStep = helpMemo(cost,index+1,n,dp);
        int twoStep = helpMemo(cost,index+2,n,dp);
        
        return dp[index] = cost[index]+Math.min(oneStep,twoStep);
    }
    public int dp(int cost[],int n){
        int dp[] = new int[n+2];
        dp[n] = 0;
        dp[n+1] = 0;
        
        //Example:- n=3, so size of dp[] = {0,0,0,0,0} i.e. n+2
        //                                  0 1 2 3 4
        //we have filled dp[3] & dp[4] with 0 although by default it is already zero
        //now we have to start filling dp[] from n-1 i.e index = 3-1 = 2
        for(int i=n-1; i>=0; i--)
            dp[i] = cost[i]+Math.min(dp[i+1],dp[i+2]);
        
        return Math.min(dp[0],dp[1]);
    }
}
