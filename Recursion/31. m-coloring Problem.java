class solve {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int color[] = new int[n];
        for(int i=0;i<n;i++)
           color[i]=-1;
        return help(0,graph,m,n,color);
    }
    public boolean help(int curr,boolean graph[][],int m,int n,int color[]){
        
        if(curr==n)return true;
        
        for(int i=0; i<m; i++){
            if(checkColor(graph,color,curr,i)){
                color[curr] = i;
                if(help(curr+1,graph,m,n,color))
                return true;
                
                color[curr] = -1;
            }
        }
        return false;
    }
    public boolean checkColor(boolean[][] graph,int color[],int curr,int i){
        for(int j=0; j<graph.length; j++){
            if(graph[curr][j]){
                if(color[j]==i)
                return false;
            }
        }
        return true;
    }
}
T.C :- n^m (for n number of node there can be m possible color)
