class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int targetSum = 0;
        for(int i=0; i<nums.length; i++)
        {
            targetSum+=nums[i];
        }
        if(targetSum%k!=0)
        {
            return false;
        }
        targetSum=targetSum/k;
        int sum = 0;
        int alreadyPicked[] = new int[nums.length];
        return helper(nums,0,1,0,targetSum,k,alreadyPicked);
    }
    boolean helper(int[] nums,int index,int bucketNum,int bucketSum,int targetSum,int k,int[] alreadyPicked)
    {
        if(bucketNum==k+1) return true;
        
        
        //if our current bucketSum is equal to targetSum call for new bucket 
        if(bucketSum==targetSum)
            return helper(nums,0,bucketNum+1,0,targetSum,k,alreadyPicked);
        
        if(bucketSum>targetSum) return false;
        
        if(index>=nums.length) return false;
        
        //if nums[index] was already picked simply call recursion for index+1
        if(alreadyPicked[index]==1)
            return helper(nums,index+1,bucketNum,bucketSum,targetSum,k,alreadyPicked);
        
        //if nums[index] was not picked by previously calls -->we have two options, a.include b.exclude
        else
        {
            //include
            bucketSum+=nums[index];
            alreadyPicked[index]=1;
            boolean ans1 = helper(nums,index+1,bucketNum,bucketSum,targetSum,k,alreadyPicked);
            
            //exclude
            bucketSum-=nums[index];
            alreadyPicked[index]=0;
            boolean ans2 = helper(nums,index+1,bucketNum,bucketSum,targetSum,k,alreadyPicked);
            
            return ans1 || ans2;
        }
    }
    
}
