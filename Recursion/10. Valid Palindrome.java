//Leetcode --> valid palindrome

class Solution{
    public boolean isPalindrome(String s) {
        String store = s.replaceAll("[^A-Za-z0-9]", "");
        store = store.toLowerCase();
        return isPalindromeHelper(store,0,store.length()-1);
    }
    
    ////Recursion 
    public boolean isPalindromeHelper(String s, int first, int last){
        if(first>=last)
            return true;
        if(s.charAt(first)==s.charAt(last))
          return isPalindromeHelper(s,first+1,last-1);
        else
            return false;
    }
    
    ////Loop
    public boolean isPalindromeHelper(String s, int first, int last){
         while(first<=last){
            if(s.charAt(first)!=s.charAt(last))
                return false;
             else{
                 first++;
                 last--;
             }
         }
        return true;
    }
}
