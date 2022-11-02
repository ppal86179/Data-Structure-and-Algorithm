//n = 5
// 1 + 2 + 3 + 4 + 5 = 15

//1. using loop     ---> T.C - O(N)
-initialize sum = 0;
-run a loop from 1 to n
-update sum with loop

Class Solution{
    public static int findSum(int n)
    {
        int sum = 0;
        for(int i=1; i<=n; i++){
           sum+=i;
        }
        return sum;
    }
}

//2. using recursion   ---> n + f(n-1)
Class Solution{
   public static int findSum(int n){
        if(n==1)
          return 1;
          
        return n + findSum(n-1);
   }
}


// 3. Using formula --> (n(n+1))/2
//T.C - O(1)
Class Solution{
   public static int findSum(int n){
         return (n * (n+1) )/2;
   }
}
