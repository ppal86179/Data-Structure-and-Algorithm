class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int sum = 0;
        Arrays.sort(candidates);
        helper(0,candidates,target,sum,ans,subset);
        return ans;
    }
    void helper(int start,int[] candidate,int target,int sum,List<List<Integer>> ans, List<Integer> subset)
    {
        if(sum==target)
        {
            ans.add(new ArrayList(subset));
            return;
        }
        
        if(start>=candidate.length)
            return;
        
        if(sum>target)
            return;
        
        //include
        sum+=candidate[start];
        subset.add(candidate[start]);
        helper(start+1,candidate,target,sum,ans,subset);
        
        //exclude
        sum-=candidate[start];
        subset.remove(subset.size()-1);
        while(start+1<candidate.length && candidate[start]==candidate[start+1])
            start++;
        helper(start+1,candidate,target,sum,ans,subset);
    }
}

/////////////////////////////////////////////////////////////or/////////////////////////////////////////////////////

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        //int sum = 0;
        Arrays.sort(candidates);
        helper(0,candidates,target,ans,subset);
        return ans;
    }
    List<List<Integer>> helper(int start,int[] candidate,int target,List<List<Integer>> ans, List<Integer> subset)
    {
        if(start>=candidate.length){
             if(target==0){
                ans.add(new ArrayList(subset));
                return ans;
             }
        }

        else{
            if(candidate[start]<=target){
              //include  
              subset.add(candidate[start]);
              helper(start+1,candidate,target-candidate[start],ans,subset);

                //exclude
                subset.remove(subset.size()-1);
             }
                 while(start+1<candidate.length && candidate[start]==candidate[start+1]){start++;}
                    helper(start+1,candidate,target,ans,subset);
         }
        return ans;
    }
}
