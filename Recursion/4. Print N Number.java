//n = 5
//output - 1 2 3 4 5

class Solution{
        public static void print(int n){
           if(n==1){
            System.out.print(n + " ");
            return;
           }
           
           print(n-1);
           System.out.print(n + " ");
        }
}
