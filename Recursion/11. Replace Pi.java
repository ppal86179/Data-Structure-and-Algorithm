package Recursion;

public class Replace_Pi {

	public static String replace(String input)
	{
		//BASE CASE:- if only single character is there return that character
		if(input.length()<=1)
			return input.substring(0);
		
// call recursion from 1st index till last index  
		String temp = replace(input.substring(1));
		
//check given string first char is 'p' or not if it is 'p' than check for recursion string ans first char is 'i' or not  
		if(temp.charAt(0)=='i' && input.charAt(0)=='p')
		{
			return "3.14"+temp.substring(1);
		}
		return input.charAt(0)+temp.substring(0);
	}
	
	public static void main(String[] args) {
		System.out.println(replace("pipix"));
	}

}
