class solve {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int Nodecolor[] = new int[n];
        for(int i=0;i<n;i++)
           Nodecolor[i]=-1;
        return help(0,graph,m,n,Nodecolor);
    }
    public boolean help(int curr,boolean graph[][],int m,int n,int Nodecolor[]){
        
        if(curr==n)return true;
        
        for(int i=0; i<m; i++){
            if(checkColor(graph,Nodecolor,curr,i)){
                Nodecolor[curr] = i;
                if(help(curr+1,graph,m,n,Nodecolor))
                return true;
                
                Nodecolor[curr] = -1;
            }
        }
        return false;
    }
    public boolean checkColor(boolean[][] graph,int Nodecolor[],int curr,int i){
        for(int j=0; j<graph.length; j++){
            if(graph[curr][j]){
                if(Nodecolor[j]==i)
                return false;
            }
        }
        return true;
    }
}
T.C :- n^m (for n number of node there can be m possible color)
