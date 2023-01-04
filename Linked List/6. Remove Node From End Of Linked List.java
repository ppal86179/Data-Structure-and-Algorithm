class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

//BRUTEFORCE APPROACH:- T.C:- O(2n)
        // ListNode temp = head;
        // int count = 0;

        // //counting total no. of nodes
        // while(temp!=null){
        //     count++;
        //     temp=temp.next;
        // }
        // if(count==n) //first corner case-->if node is head node
        //  return head.next;
        // int i = count-n;
        // temp = head;

        // //Traversing to the previous node of that node which we are going to delete
        // while(i!=1){
        //     temp=temp.next;
        //     i--;
        // }
        // if(n==1)  //Second corner case--> if node is last node
        //     temp.next=null;
        // else
        // temp.next=temp.next.next;

        // return head;

//OPTIMAL APPROACH:- T.C:- O(n)
            ListNode temp = new ListNode();
            temp.next=head;
            ListNode fast = temp;
            ListNode slow = temp;

            for(int i=1; i<=n; i++){
                fast=fast.next;
            }

            while(fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
            slow.next=slow.next.next;
            return temp.next;
    }
}
