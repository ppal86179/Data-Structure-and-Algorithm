//n = 8th term, given --> 0th term is 0  &  1st term is 1 
// 0 1 1 2 3 5 8 13 21 .......

class Solution{
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        
        return fib(n-1) + fib(n-2);
    }
}
