package Recursion;

public class Find_FirstIndex_Of_Number {

	public static int firstIndex(int input[], int x)
	{
		return firstIndex(input,x,0);
	}
	
	private static int firstIndex(int input[] , int x, int startIndex)
	{
		 //BASE CASE--> if only one element is there check it is equal to x or not
			if(startIndex>=input.length-1)
			{
				if(input[startIndex]==x)
				{
					return startIndex;
				}
				else
					return -1;
			}
			
			
			//Recursion--> recursion will give their ans
			int ans = firstIndex(input,x,startIndex+1);
			

			//our work --> check first element if it is equal to x return that index else return recursion ans 
			if(input[startIndex]==x)
			{
				return startIndex;
			}
			else
			return ans;
	}
	public static void main(String[] args)
	{
		int input[] = {1,2,3,4,5};
		System.out.println(firstIndex(input,5));
		System.out.println(firstIndex(input,7));
	}
}
