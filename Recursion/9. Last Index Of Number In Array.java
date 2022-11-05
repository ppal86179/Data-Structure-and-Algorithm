package Recursion;

public class Find_LastIndex_Of_Number {

	public static int lastIndex(int input[],int x)
	{
	     return lastIndex(input,x,0);	
	}
	
	private static int lastIndex(int input[], int x, int startIndex)
	{
		
		if(startIndex==input.length-1)
		{
		     if(input[startIndex]==x)
		     {
		       return startIndex;
		     }
		     else
		     {
		    	// System.out.println("1. -1");
						return -1;
		     }
		}
		int ans = lastIndex(input,x,startIndex+1);
		if(ans!=-1)
		{
			return ans;
		}
		else
		{
			if(input[startIndex]==x)
				return startIndex;
			else
			//	System.out.println("2. -1");
				return -1;
		}
	}
	
	public static void main(String[] args) {
	
		int input[] = {1,3,5,4,6};
		System.out.println(lastIndex(input,5));
	}

}
