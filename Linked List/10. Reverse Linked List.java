class Solution {
    public ListNode reverseList(ListNode head) {
    //Three Pointer Approach    
        // if(head==null || head.next==null)return head;
        // ListNode prev = null;
        // ListNode currentP = head;
        // ListNode nextP = head.next;

        // while(currentP!=null){
        //     currentP.next = prev;
        //     prev = currentP;
        //     currentP = nextP;

        //     if(nextP!=null)
        //     nextP=nextP.next;
        // }
        // return prev;

    //Recursive Approach
    if(head==null || head.next==null)return head;

    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
    }
}
