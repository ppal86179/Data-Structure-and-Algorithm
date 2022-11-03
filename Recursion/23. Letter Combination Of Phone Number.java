class Solution {
    public List<String> letterCombinations(String digits) {
     String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
     StringBuffer store = new StringBuffer();
     List<String> ans = new ArrayList<>();
        if(digits.length()==0)
            return ans;
        
        helper(0,digits,ans,store,str);
        return ans;
    }
    
    void helper(int i, String digits,List<String> ans,StringBuffer store,String[] str)
    {
        if(i>=digits.length())
        {
            ans.add(store.toString());
            return;
        }
    
        int tempI = digits.charAt(i) - '0';
        String tempS = str[tempI];
        
        for(int j=0; j<tempS.length(); j++)
        {
            char c = tempS.charAt(j);
            store.append(c);
            helper(i+1,digits,ans,store,str);
            store.deleteCharAt(store.length()-1);
        }
    }
}
