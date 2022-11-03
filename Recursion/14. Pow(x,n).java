class Solution {
    public double myPow(double x, int n) {
       
        return help(x,n);
    }
    double help(double x,long n)
    {
          if(n==0)
              return 1;
        if(n<0)
        {
            n = -n;
            x = 1/x;
        }
        if(n%2==0)
            return help(x*x,n/2);
        return x*help(x,n-1);
        
    }
}
TIME COMPLEXITY: - O(logn)
example:- 2^64
recursion calls will be
2^64 --> (4)^32 -->(16)^16 -->(256)^8-->(65536)^4-->(4294967296)^2-->(1.84467....)^1-->(1.84467..)^0 

64 --> 32-->16-->8-->4-->2-->1  :- this is G.P series (n--->n/2--->n/4-->n/8-->n/16-->n/32-->n/64)
  
  general term of G.P.
n/2^0 --> n/2^1 --> n/2^2 --> n/2^3-->.......n/2^k 

comparing both 
n/2^k = 1
n = 2^k
tak log on both side
log(n) = log(2^k)
log(n) = klog2
divide both side by log2
k = log(n)
T.C :- log(n)
