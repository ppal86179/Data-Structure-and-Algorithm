1. First Approach
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums,0);
    }
    public List<List<Integer>> helper(int[] nums, int index)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if(index==nums.length){
            List<Integer> store = new ArrayList<>();
            ans.add(store);
            return ans;
        }
        
        List<List<Integer>> partialAns = helper(nums,index+1);
        
        for(List<Integer> list : partialAns){
            ans.add(list);
        }
        
        for(List<Integer> list : partialAns){
           List<Integer> list1 = new ArrayList<>();
            list1.add(nums[index]);
            for(int elem:list)
                list1.add(elem);
            
            ans.add(list1);
        }
        return ans;
    }
}

2. Second Approach
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       
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
        subset.remove(subset.size()-1);
        helper(nums,index+1,ans,subset);
    }
}
