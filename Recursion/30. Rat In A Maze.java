import java.util.*;
public class Solution {
    public static ArrayList < String > findSum(int[][] arr, int n) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        help(0,0,arr,n,path,ans);
        return ans;
    }
    public static void help(int i, int j,int[][] arr, int n,StringBuffer path, ArrayList<String> ans)
    {
        if(i<0 || j<0 || i==n || j==n || arr[i][j]!=1)
            return;
        
        if(i==n-1 && j==n-1)
        {
            ans.add(path.toString());
            return;
        }
        
        arr[i][j] = 0;
        //down
        path.append('D');
        help(i+1,j,arr,n,path,ans);
        path.deleteCharAt(path.length()-1);
        
        //left
        path.append('L');
        help(i,j-1,arr,n,path,ans);
        path.deleteCharAt(path.length()-1);
        //right
        path.append('R');
        help(i,j+1,arr,n,path,ans);
        path.deleteCharAt(path.length()-1);
        //up
        path.append('U');
        help(i-1,j,arr,n,path,ans);
        path.deleteCharAt(path.length()-1);
        
        arr[i][j] = 1;
    }
}

T.C :- O(4^x) , where x = m*n 

Explanation :- for every cell there are 4 direction i.e. we are calling 4 time recursion for m*n cells
