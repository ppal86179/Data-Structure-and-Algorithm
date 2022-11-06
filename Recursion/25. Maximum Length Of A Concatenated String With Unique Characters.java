1. First Approach :- BruteForce Approach
Step1 :- generate all subsequences
step2 :- check each subsequences has unique character or not
step3 :- maintain max variable for length of each subsequence which has unique character
class Solution {
    public int maxLength(List<String> arr) {
        List<String> temp = new ArrayList();
        List<String> store = new ArrayList();
        getSubsequence(arr,0,store,temp);

        return maxLen(store,0);
    }
    void getSubsequence(List<String> arr, int index,List<String> store,List<String> temp){
        if(index==arr.size()){
            String sum = "";
            for(String s:temp){
                sum+=s;
            }
            store.add(sum);
            return;
        }
        //include
        temp.add(arr.get(index));
        getSubsequence(arr,index+1,store,temp);
        
        //exclude
        temp.remove(temp.size()-1);
        getSubsequence(arr,index+1,store,temp);
        
    }
    int maxLen(List<String> store, int max){
        int map[] = new int[26];
         for(int i=0; i<store.size(); i++){
            if(getMax(store.get(i),map)){
                String p = store.get(i);
                max = Math.max(max,p.length());
            }
        }
        return max;
    }
    boolean getMax(String string, int[] map){
        map = new int[26];
        for(int i=0; i<string.length(); i++){
            if(map[string.charAt(i)-'a']==1)return false;
            else
                map[string.charAt(i)-'a'] = 1;
        }
        return true;
    }
}
T.C :- 2^n(for generating subsequences) * k(max length of subsequence i.e. loop for adding each string e.g. un+iq+ue)  + 2^n(checking each subsequnce for unique character) * k(max length of subsequence)
      
2. Second Approach :- removing extra O(2^n * k) we are not first generating all subsequence this time
class Solution {
    public int maxLength(List<String> arr) {
        
        int visited[] = new int[26];
        return helper(arr,visited,0,0);
    }
    
    boolean checking(int[] visited, String CurrentString)
    {
        
        //self check for current string having repeated character or not
        int[] self = new int[26];
        for(int i=0; i<CurrentString.length(); i++)
        {
            if(self[CurrentString.charAt(i)-'a']==1)
                return false;
            self[CurrentString.charAt(i)-'a'] = 1;
        }
        
        //for checking character of Current string is present in previous String or not
        for(int i=0; i<CurrentString.length(); i++)
        {
            if(visited[CurrentString.charAt(i)-'a']==1)
                return false;
        }
        return true;
    }
    
    
    int helper(List<String> arr,int[] visited,int index,int length)
    {
          if(index==arr.size())
            return length;
        
        String CurrentString = arr.get(index);
        
//checking current string each character is previously contained or not if contain simply call for next string
        if(!checking(visited,CurrentString))
            return helper(arr,visited,index+1,length);
//if current string's characters are not previously visited we have two option 1.pick this string for calculating length 2. not pick 
        else{
            
            //include
            //first of all mark 1 in visited array for each character
            for(int i=0; i<CurrentString.length(); i++)
            {
                visited[CurrentString.charAt(i)-'a'] = 1;
            }
            //add that current string length into length
            length +=CurrentString.length();
            //call recursion for remaining task
            int ans1 = helper(arr,visited,index+1,length);
            
            //exclude
            //undo all changes we made
            for(int i=0; i<CurrentString.length(); i++)
            {
                visited[CurrentString.charAt(i)-'a'] = 0;
            }
            length-=CurrentString.length();
            int ans2 = helper(arr,visited,index+1,length);
            
            return Math.max(ans1,ans2);
            
        }
    }
}
