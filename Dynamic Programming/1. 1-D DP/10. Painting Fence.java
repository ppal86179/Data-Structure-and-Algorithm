class Solution
{
    
    public static int mod = 1000000007;
    long countWays(int n,int k)
    {
        long dp[] = new long[n+1];
        for(int i=0; i<n+1; i++)
        dp[i]=-1;
        // return Memo(n,k,dp)%mod;
        return dp(n,k)%mod;
    }
    long Memo(int n, int k,long dp[]){
        if(n==1)return k;
        if(n==2)return k + (k*(k-1));
        if(dp[n]!=-1)return dp[n];
        
        long ans1  = ( (Memo(n-2,k,dp)%mod) * ( (k-1)%mod) )%mod; 
        long ans2 =  ( (Memo(n-1,k,dp)%mod) * ( (k-1)%mod) )%mod;
        return dp[n] = (ans1+ans2)%mod;
    }
    long dp(int n,int k){
        long dp[] = new long[n+1];
        if(n==1)return k;
        dp[1] = k%mod;
        dp[2] = (k%mod + (k*(k-1))%mod)%mod;
        
        for(int i=3; i<n+1; i++){
                long ans1  = ( (dp[i-2]%mod) * ( (k-1)%mod) )%mod; 
                long ans2 =  ( (dp[i-1]%mod) * ( (k-1)%mod) )%mod;
         dp[i] = (ans1+ans2)%mod;
        }
        return dp[n];
    }
}
