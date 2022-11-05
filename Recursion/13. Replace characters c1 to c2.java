package Recursion;

public class Replace_character {

	public static String replaceCharacter(String input, char c1, char c2)
	{
		if(input.length()<=1)
		{
			if(input.charAt(0)==c1)
			{
				return ""+c2;
			}
			else
				return input;
		}
		
		String store = replaceCharacter(input.substring(1),c1,c2);
		if(input.charAt(0)==c1)
			return c2+store.substring(0);
		else
			return input.charAt(0)+store.substring(0);
	}
	
	public static void main(String[] args) {
		
		System.out.println(replaceCharacter("abacd",'a','x'));
	}

}
OUTPUT :- xbxcd
