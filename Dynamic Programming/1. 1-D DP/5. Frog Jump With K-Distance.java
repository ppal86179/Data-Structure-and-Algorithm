Now this time rather than taking one or two jumps there can be k-jumps
public class Solution {
    public static int frogJump(int n, int heights[],int k) {
      //1. Recursion  
      return help(n-1,heights,n,k);
    }
    public static int help(int index, int heights[], int n,int k)
    {
        if(index==0)
            return 0;
        
        int minStep = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
          if(index>=0){
              int jump = help(index-i) + Math.abs(heights[index] - heights[index-i]);
              minStep = Math.min(minStep,jump);
          }
        }
        return minStep;
    }
}
