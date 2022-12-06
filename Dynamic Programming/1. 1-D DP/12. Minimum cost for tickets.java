class Solution {
    public int mincostTickets(int[] days, int[] costs) {
         return help(days,costs,0);
        // int dp[] = new int[days.length+1];
        // for(int i=0; i<days.length+1; i++)
        // {
        //     dp[i] = -1;
        // }
        //return helpMemo(days,costs,0,dp);
        //return helpDP(days,costs);
    }
    int help(int days[], int costs[], int index)
    {
        if(index>=days.length)
            return 0;
        
        //1 day pass
        int op1 = costs[0] + help(days,costs,index+1);
        
        //7 day pass
        int i;
        for(i=index; i<days.length && days[i]<days[index]+7; i++);

                                     // or 
        // for( i=index; i<days.length; i++){
        //     if(days[i]>=days[index]+7)
        //     break;
        // }
        int op2 = costs[1] + help(days,costs,i);
        
        //30 day pass
        for(i=index; i<days.length && days[i]<days[index]+30; i++);
        
                                      // or
        // for( i=index; i<days.length; i++){
        //     if(days[i]>=days[index]+30)
        //     break;
        // }
            
        int op3 = costs[2] + help(days,costs,i);
        
        return Math.min(op1,Math.min(op2,op3));
    }
    
    int helpMemo(int days[], int costs[], int index, int dp[])
    {
        if(index>=days.length)
            return 0;
        
        if(dp[index]!=-1)
            return dp[index];
        //1 day pass
        int op1 = costs[0] + helpMemo(days,costs,index+1,dp);
        
        //7 day pass
        int i;
        for(i=index; i<days.length && days[i]<days[index]+7; i++);
            
        int op2 = costs[1] + helpMemo(days,costs,i,dp);
        
        //30 day pass
        for(i=index; i<days.length && days[i]<days[index]+30; i++);
            
        int op3 = costs[2] + helpMemo(days,costs,i,dp);
        
           dp[index] = Math.min(op1,Math.min(op2,op3));
        return dp[index];
    }
    int helpDP(int days[], int costs[])
    {
        int n = days.length;
        int dp[] = new int[n+1];
        for(int i=0; i<n+1; i++)
        {
            dp[i] = Integer.MAX_VALUE;
        }
        //step2 : base case analyse
        dp[n] = 0;
        
        //step3 : iterate over remaining part (copy paste recursion solution)
        for(int k=n-1; k>=0; k--)
        {
          //1 day pass
          int op1 = costs[0] + dp[k+1];
        
          //7 day pass
          int i;
           for(i=k; i<n && days[i]<days[k]+7; i++);
            
          int op2 = costs[1] + dp[i];
        
          //30 day pass
           for(i=k; i<n && days[i]<days[k]+30; i++);
            
          int op3 = costs[2] + dp[i];
        
           dp[k] = Math.min(op1,Math.min(op2,op3));
        }
        return dp[0];
    }
    
}
