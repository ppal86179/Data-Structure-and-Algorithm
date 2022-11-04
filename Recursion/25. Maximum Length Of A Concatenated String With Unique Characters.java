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
        
//checking current string each character is previously contained or not if contain simply call fr next string
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
