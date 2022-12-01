class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        for(int i=0; i<n+1; i++)
        {
            dp[i] = -1;
        }
        return helpDP(n);
    }
    int help(int n)
    {
        if(n==0)
            return 0;
        int ans = n;
        for(int i=1; i*i<=n; i++)
        {
            int temp = i*i;
            ans = Math.min(ans,1+help(n-temp));
        }
        return ans;
    }
    int helpMemo(int n,int dp[])
    {
          if(n==0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int ans = n;
        for(int i=1; i*i<=n; i++)
        {
            int temp = i*i;
            ans = Math.min(ans,1+helpMemo(n-temp,dp));
        }
        dp[n] = ans;
        return dp[n];
    }
    int helpDP(int n)
    {
        int dp[] = new int[n+1];
        for(int i=0; i<n+1; i++)
        {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
            
        for(int i=1; i<n+1; i++)
        {
             for(int j=1; j*j<=n; j++)
             {
                int temp = j*j;
                 if(i-temp>=0)
                dp[i] = Math.min(dp[i],1+dp[i-temp]);
             }
        }
        return dp[n];
            
    }
}
