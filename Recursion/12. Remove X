//Eclipse-->recursion

class Solution{
  public static String removeX(String input)
	{
		if(input.length()<=1){
			if(input.charAt(0)=='x'){
				return "";
			}
			else
				return input.substring(0);
		}
		
		String temp = removeX(input.substring(1));
		
		if(input.charAt(0)=='x'){
			return temp;
		}
		return input.charAt(0)+temp.substring(0);
	}
}
