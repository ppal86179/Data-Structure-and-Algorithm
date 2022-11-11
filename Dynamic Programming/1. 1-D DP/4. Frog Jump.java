EXAMPLE:- height[10,20,30,10], n=4
  Frog is standing at 1st stair(index = 0) and they want to reach to n i.e. 4th stair 
  frog can jump either one stair or two stair at a time and each time they climb stair it will cost some energy
  i.e. frog jump from i to j, energy will [j]-[i]
return minimum energy required

step 1:- represent in index 
we can represent stair as index , f(n-1) :- will give minimum energy required to reach from n-1 from 0
  
  //Base Case :- we are decreasing n(3-->2-->1-->0(last index))
  f(0) :- energy required to reach 0 from 0 is 0
  if(index==0) return 0;

step 2:- Explore All possibilities

oneStep = f(index-1) + absoulte([index]-[index-1])
twoStep = f(index-2) + absolute([index]-[index-2])
  
step 3:- return minimum
  return min(oneStep,twoStep)
  
                           NOTE:- if we are at index=1 or 0 we can't take twoStep back (index-2),
                             so, if(index>1)
                               twoStep = f(index-2) + absolute([index]-[index-2])
                               
public class Solution {
    public static int frogJump(int n, int heights[]) {
      //1. Recursion  
      //return help(n-1,heights,n);
      
      //2. Memoization - Top-down DP
      //int dp[] = new int[n+1];
      //for(int i=0; i<n+1; i++)
          //dp[i] = -1;
      //return helpMemo(n-1,heights,n,dp);
      
      //3. Tabulation - Bottom-up DP
      return dp(heights,n);
    }
    public static int help(int index, int heights[], int n)
    {
        if(index==0)
            return 0;
 
        int oneStep =  help(index-1,heights,n) + Math.abs(heights[index] - heights[index-1]);
        int twoStep = Integer.MAX_VALUE;
        if(index>1)
        twoStep =  help(index-2,heights,n) + Math.abs(heights[index] - heights[index-2]);
        
        return Math.min(oneStep,twoStep);
    }
    public static int helpMemo(int index, int heights[], int n, int dp[])
    {
        if(index==0)
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        int oneStep = Integer.MAX_VALUE;
        int twoStep = Math.abs(heights[index] - heights[index-1]) + helpMemo(index-1,heights,n,dp);
        
        if(index>1)
        oneStep = Math.abs(heights[index] - heights[index-2]) + helpMemo(index-2,heights,n,dp);
        
        return dp[index] = Math.min(oneStep,twoStep);
    }
    public static int dp(int heights[], int n){
        int dp[] = new int[n+1];
        dp[0]=0;
        for(int i=1; i<n; i++)//if n=4,recursion calling will 3-->2-->1-->0 then in tabulation 0-->1-->2-->3 i.e. n-1
        {
            int twoStep = Integer.MAX_VALUE;
            if(i>1)
            twoStep = Math.abs(heights[i]-heights[i-2]) + dp[i-2];
            int oneStep = Math.abs(heights[i]-heights[i-1]) + dp[i-1];
            dp[i] = Math.min(oneStep,twoStep);
        }
      //return what we pass in recursion i.e. f(n-1)
        return dp[n-1];
    }
}
