//GFG practice Question

class Solution{
    static long factorial(int N){
        if(N==1 || N==0)return 1;
        
        return N * factorial(N-1);
    }
}
T.C :- O(n) :- for both iterative and recursive solution
