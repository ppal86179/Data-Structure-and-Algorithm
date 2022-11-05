class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,ans,subset);
        return ans;
    }
        public void helper(int[] nums, int index, List<List<Integer>> ans, List<Integer> subset)
    {
        
        if(index==nums.length)
        {
            ans.add(new ArrayList(subset));
            return;
        }
        
        //include
        subset.add(nums[index]);
        helper(nums,index+1,ans,subset);
        
        //exclude
            while(index+1<nums.length && nums[index]==nums[index+1]){
                index++;
            }
        subset.remove(subset.size()-1);
        helper(nums,index+1,ans,subset);
    }
}
