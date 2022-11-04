class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        List<String> path = new ArrayList();
        help(0,s,path,ans);
        return ans;
    }
    void help(int index, String s, List<String> path, List<List<String>> ans)
    {
        //BASE CASE
        if(index==s.length())
        {
            ans.add(new ArrayList(path));
            return;
        }
        
        //recursion
        for(int i=index; i<s.length(); i++)
        {
            if(isPalindrome(index,i,s))
            {
                path.add(s.substring(index,i+1));
                help(i+1,s,path,ans);
                path.remove(path.size()-1);
            }
        }
    }
    boolean isPalindrome(int start, int end, String s)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
