1. First Approach

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
		    helper(1,n,ans,subset);
       
        List<List<Integer>> finalAns = new ArrayList<>();
        for(List<Integer> list : ans){
            if(list.size()==k)
                finalAns.add(list);
        }
        return finalAns;
    }
     public void helper(int start, int n, List<List<Integer>> ans, List<Integer> subset)
    {
      	//BASE CASE
        if(start>=n+1){
            ans.add(new ArrayList<>(subset));
            return;
        }
        
        //include
        subset.add(start);
        helper(start+1 ,n,ans,subset);
        
        //exclude
        subset.remove(subset.size()-1);
        helper(start+1,n,ans,subset);
    }
	T.C :- 2^n(for generating all subsets) * 2^n(looping to get k size subset from 2^n subsets )
}

2. Second Approach
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(1,n,k,ans,subset);
        return ans;
    }
    void helper(int start, int n, int k,List<List<Integer>> ans, List<Integer> subset)
    {
        
        if(start>n)
        {
            if(k==0)
            {
                ans.add(new ArrayList(subset));
            }
            return;
        }
        
        //include
        subset.add(start);
        helper(start+1,n,k-1,ans,subset);
        
       //exclude
        subset.remove(subset.size()-1);
        helper(start+1,n,k,ans,subset);
    }
}
