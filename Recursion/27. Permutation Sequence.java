1. First Approach
//generate all permutation for 1 to n
//store all permutation in some data structure
//return kth term from data structure

//Example :- n=3 , k=4
//Generate permutations(LeetCode Qus. 46 :- Permutations) 1 to 3 i.e. 
123
132
213
231
312
321
//k=4th term is 231
//our ans will be 231

import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        int num[] = new int[n];
        for(int i=0; i<n; i++)
        {
            num[i] = i+1;
        }
        List<String> Tans = new ArrayList<>();
        help(0,num,n,k,Tans);
        Collections.sort(Tans);
        return Tans.get(k-1);
    }
    void help(int index, int[] num, int n, int k, List<String> Tans)
    {
        
        if(index==num.length){
            StringBuffer store = new StringBuffer();
            for(int i=0; i<n; i++)
            {
                store.append(num[i]);
            }
            Tans.add(store.toString());
            return;
        }
        
        for(int i=index; i<n; i++)
        {
            swap(i,index,num);
            help(index+1,num,n,k,Tans);
            swap(i,index,num);
        }
    }
    void swap(int i, int j, int[] num)
    {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
 //T.C :- n!(for generating permutation) * n(for looping i=0 to nums.length) * n!logn(for sorting n! permutation)
}

2. Optimal Approach :- using Mathematics
//Example :- n=4 ,k=17
                                 /////////STEP 1
//We can have our permutation starting with either 1 or 2 or 3 or 4.
//If first position is occupied by one number then there are three more positions left.
//Then remaining three numbers can be permuted among themselves 3! = 6 sequences.

//if we consider sequences as 0-based index in sorted form
0th block  |0th – 5th permutation will start with 1   | {2,3,4}
1st block  |6th – 11th permutation will start with 2  | {1,3,4}
2nd block  |12th – 17th permutation will start with 3 | {1,2,4}
3rd block  |18th – 23rd permutation will start with 4 | {1,2,3}

//make K = 17-1 considering 0-based indexing
//Since each of the four blocks illustrated above comprises 6 permutations, therefore the 16th permutation will lie in (16 / 6 ) = 2nd block i.e. 3 ans={3---}
/and our answer is the (16 % 6) = 4th sequence from the 2nd block.
    
                                  //////////STEP 2
  //Our new search space comprises three elements {1,2,4} where K = 4 
  //If first position is occupied by one number then there are two more positions left.
  //Then remaining two numbers can be permuted among themselves 2! = 4 sequences.

0th block  |0th – 1st sequence starts with 1 | {2,4} 
1st block  |2nd – 3rd sequence starts with 2 | {1,4}
2nd block  |4th – 5th sequence starts with 4 | {1,2}

//(4/2) = 2nd block i.e 4   ans={34--}
//4%2 = 0th sequence from 2nd block

                                     /////////STEP 3
        //Our new search space comprises three elements {1,2} where K = 0
        //If first position is occupied by one number then there are one more positions left.
        //Then remaining one numbers can be permuted among themselves 1! = 1 sequences.
0th block |0th sequence starts with 1  | {2} 
1st block |1st sequence. starts with 2 | {1}

//(0/1) = 0th block i.e. ans={341}
//0%1 = 0th sequence from 0th block

                                   /////////STEP 4
//only 2 is remaining 
ans = {3412}

class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList < Integer > numbers = new ArrayList < > ();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k - 1;
        while (true) {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
}
T.C:- n(for placing n numbers in n positions) * n(for every number we are reducingthe search space by removing one element, 1234-->124-->12-->1)
