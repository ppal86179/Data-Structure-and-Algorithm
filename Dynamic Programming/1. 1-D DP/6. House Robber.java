//Let's try all subsequences with given constraint that is not include adjacent element
//and out of all subsequences pick that one with maximum sum
//and when we say about "try all possibilities" --> use recursion and we know how to generate subset/subsequences by usiing --> Include/Not include

class Solution {
    public int rob(int[] nums) {
        
        //1.Recursion
        //return help(nums.length-1,nums);
        
        //2.Memoization - Top-down DP
        // int[] dp = new int[nums.length];
        // for(int i=0; i<dp.length; i++)
        // {
        //     dp[i] = -1;
        // }
        // return Memo(nums.length-1,nums,dp);
        
        //3.Tabulation - Bottom-Up Dp
        return DP(nums,nums.length);
    }
    
    int help(int index,int[] nums){
        if(index==0)return nums[0];
        if(index<0)return 0;
           
        int include = help(index-2,nums) + nums[index];
        int exclude= help(index-1,nums);
        
        return Math.max(include,exclude);
    }
    int Memo(int index,int[] nums, int dp[]){
        if(index==0)return nums[0];
        if(index<0)return 0;
        if(dp[index]!=-1)return dp[index];
           
        int include = Memo(index-2,nums,dp) + nums[index];
        int exclude= Memo(index-1,nums,dp);
        
        return dp[index]=Math.max(include,exclude);
    }
    int DP(int[] nums, int n){
        int dp[] = new int[n];

        dp[0] = nums[0];
        for(int i=1; i<n; i++){
            int include = nums[i];
            if(i>1){
               include = include + dp[i-2];
            }  
            int exclude = dp[i-1];
            dp[i] = Math.max(include,exclude);
        }
        return dp[n-1];
    }
}
