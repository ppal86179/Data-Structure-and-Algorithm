class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int oldColor = image[sr][sc];
        if(oldColor==color)
            return image;
        int x = image.length;
        int y = image[0].length;
        helper(image,sr,sc,oldColor,color,x,y);
        return image;
    }
    void helper(int[][] image,int i,int j,int oldColor,int newColor,int x,int y)
    {
        if(i<0 || j<0 || i==x || j==y || image[i][j]!=oldColor)
            return;
        
        image[i][j] = newColor;
        //Down
        helper(image,i+1,j,oldColor,newColor,x,y);
        //up
        helper(image,i-1,j,oldColor,newColor,x,y);
        //right
        helper(image,i,j+1,oldColor,newColor,x,y);
        //left
        helper(image,i,j-1,oldColor,newColor,x,y);
    }
}
T.C :- O(m*n)  ,m and n are number of row and column 
