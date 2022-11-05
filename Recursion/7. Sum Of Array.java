//GFG practice question

class Get
{
    public static int sumElement(int arr[], int n)
    {
        if(n==0) return 0;
        if(n==1)return arr[0];
        
        return helper(arr,0);
    }
    public static int helper(int arr[],int startIndex){
    
    //BASE CASE -->  if only one element is given, array size is 1 (arr[] = {1}) and it's index is arr.length-1
    // and if only one element is given sum is that one element itself
    
        if(startIndex==arr.length-1)
        return arr[startIndex];
    
        int ans = helper(arr,startIndex+1);
        
        return arr[startIndex] + ans;  
    }
}
