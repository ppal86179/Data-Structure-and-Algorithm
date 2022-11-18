public class Solution {
	public static long countDerangements(int n) {
        long[] dp = new long[n+1];
        for(int i=0; i<n+1; i++)
        {
            dp[i] = -1;
        }
		//return(helpMEMO(n,1000000007,dp));
        return(helpDP(n,1000000007));
	}
    public static long help(int n,long mod)
    {
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        long ans = ((n-1)%mod * (  (help(n-2,mod))%mod + (help(n-1,mod))%mod   )   )%mod;
        return ans;
    }
    public static long helpMEMO(int n, long mod, long[] dp)
    {
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        long ans = ((n-1)%mod * ((helpMEMO(n-2,mod,dp))%mod + (helpMEMO(n-1,mod,dp))%mod))%mod;
        dp[n] = ans;
        return dp[n];
    }
    public static long helpDP(int n, long mod)
    {
         long[] dp = new long[n+1];
        for(int i=0; i<n+1; i++)
        {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3; i<n+1; i++)
        {
            dp[i] = ((i-1)%mod * ((dp[i-2])%mod + (dp[i-1])%mod))%mod;
        }
        return dp[n];
    }
}
