VERY IMPORANT QUESTION
BUT SIMPLE SOLUTION --> FOLLOW UP OF REVERSE LINKED LIST


reverse nodes in groups of k, means when we are reversing the nodes we are in boundation of k nodes

i.e.
  int count = 0;
  while(currentP!=null  &&  count<k){
    -----
      ------
      -------
      count++;
  }

if nodes are not properly divided into k group, example:- 1-2-3-4-5-6-7-8 ,k=3
  (1-2-3)-(4-5-6)-(7-8)  o/p = (3-2-1)-(6-5-4)-(7-8) ==> Leetcode
                               (3-2-1)-(6-5-4)-(8-7) ==> CodeStudio & GFG

//Leetcode --> we need to track size of remaining nodes if remaining nodes are less than k we are not going to reverse those node 
//GFG/Codestudio --> we don't need to keep the track of remaing just simply reverse 

class Solution{
    public ListNode reverseKGroup(ListNode head,int k){
        //Base case
        if(head==null)return head;
        
        //calculate length
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
           temp=temp.next;
           len++;
        }
        if(len<k) //example:- 1-2-3,k=4  len=3<4 we cant make group
           return head;
        
        //Reverse Linked List(Three pointer method)
        ListNode prevP = null;
        ListNode currP = head;
        ListNode nextP = null;
        int count = 0;
        while(currP!=null && count<k){
           nextP = currP.next;
           currP.next = prev;
           prevP = currP;
           currP = nextP;
           count++;
        }
        
        //recursion will handle remaining group
        if(nextP!=null)
        head.next = reverseKGroup(nextP,k);
        
        return prevP;
    }
}
