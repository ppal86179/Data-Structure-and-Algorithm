1. First Approach 
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> subset = new ArrayList();
        boolean map[] = new boolean[nums.length];
        helper(nums,subset,ans,map);
        return ans;
    }
    public static void helper(int nums[],List<Integer> subset,List<List<Integer>> ans,boolean map[]){
        if(subset.size()==nums.length){
            ans.add(new ArrayList(subset));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!map[i]){
                subset.add(nums[i]);
                map[i]=true;
                helper(nums,subset,ans,map);
                subset.remove(subset.size()-1);
                map[i]=false;
            }
        }
    }
}
T.C:- n!(for generating all permutation) * n(for map loop)
S.C :- EXTRA SPACE :- n(for subset data structure) + n(for map data structure)
      :- Auxillary Space :- recursion stack i.e. O(n)
        
2. Second Approach
class Solution {
    public List<List<Integer>> permute(int[] nums) {
          List<List<Integer>> ans = new ArrayList<>();
	        helper(nums,0,ans);
	        return ans;
    }
    public void helper(int[] nums, int index, List<List<Integer>> ans)
	    {
	    	if(index==nums.length){
	    		    ArrayList<Integer> list =new ArrayList<>();
	    	        for(int i = 0 ; i<nums.length ; i++){
	    	            list.add(nums[i]);
	    	        }
	    	        ans.add(list);
	    	        return;
	    	}
	        for(int i = index; i<nums.length; i++){
	            swap(i,index,nums);
	            helper(nums, index+1, ans);
	            swap(i,index,nums);
	        }
	    }
	    public static void swap(int i , int j, int[] nums){
	    	  int t=nums[i];
	    	    nums[i]=nums[j];
	    	    nums[j]=t;
	    }
}
