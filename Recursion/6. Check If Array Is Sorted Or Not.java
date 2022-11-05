// GFG Practice Question

class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
        if(n==0 || n==1)
        return true;
        
        return helper(arr,0);
    }
    boolean helper(int arr[], int Startindex){
        
        //Base Case --> if only one element is given, array size is 1 (arr[] = {1}) and it's index is arr.length-1
        if(Startindex == arr.length-1)  
        return true;
        
        
        //our work
        if(arr[Startindex] > arr[Startindex+1])
        return false;
        
        //recursion
//         boolean ans = helper(arr,Startindex+1);
//         return ans;
        return helper(arr,Startindex+1);
    }
}
