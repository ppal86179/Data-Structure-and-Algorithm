class Solution {
    public int getDecimalValue(ListNode head) {
    //BruteForce Approach
        // int length = 0;
        // ListNode temp = head;
        // while(temp!=null){
        //     temp=temp.next;
        //     length++;
        // }
        // length--;
        // temp=head;
        // int ans = 0;
        // while(temp!=null){
        //     int value = temp.val;
        //     ans+=(Math.pow(2,length) * value);
        //     length--;
        //     temp=temp.next;         
        // }
        // return ans;

    //optimal Approach
    //suppose our first node is last node that means, ans = 2^0 * node.val = node.val
    //then we come to next node and realized previous node is not the last node multiply our ans with 2, ans = ans*2;
    //and also add current node.val
    int ans = 0;
    ListNode temp = head;
    while(temp!=null){
        ans*=2; //multiply previous ans with 2 because this is not last node
        ans+=temp.val; // also add current node val
        temp=temp.next;
    }
    return ans;
    }
}
