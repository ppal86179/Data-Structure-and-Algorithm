//Eclipse-->Recursion

class Solution{
   public static int lastIndex(int input[],int x)
	{
	     return lastIndex(input,x,0);	
	}
	private static int lastIndex(int input[], int x, int startIndex)
	{
		//BASE CASE
		if(startIndex==input.length-1){
		     if(input[startIndex]==x){
		       return startIndex;
		     }
		     else{
						return -1;
		     }
		}
    
    //Recursion
		int ans = lastIndex(input,x,startIndex+1);
    
    //our work --> if recursion will not give -1 that means we found last index return that index
    //but if recursion give -1 as ans then we need to check our first element
		if(ans1=-1){
			return ans;
		}
		else{
			if(input[startIndex]==x)
				return startIndex;
			else
				return -1;
		}
	}
}
