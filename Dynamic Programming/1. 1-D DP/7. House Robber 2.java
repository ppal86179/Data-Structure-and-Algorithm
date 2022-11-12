Solution - if we rob first house then we can't rob last house and and if we rob last house we can;t rob first house
           our previous solution of question House Robber 1 will work fine if we pass array without first element and then pass array without last element and return 
           maximum of them
           
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];
        for(int i=0; i<n-1; i++){
            arr1[i] = nums[i];    //include first element and not include last element
            arr2[i] = nums[i+1];  //not include first element and include last element
        }
        int x = arr1.length-1;
        return Math.max(help(arr1,x), help(arr2,x));
    }
    public int help(int[] nums,int index){
        if(index==0)return nums[index];
        if(index<0)return 0;
        
        int include = nums[index] + help(nums,index-2);
        int notInclude = help(nums,index-1);
        
        return Math.max(include,notInclude);
    }
}
