/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //Using HashSet
        // HashSet<ListNode> set = new HashSet<>();
        // ListNode temp = head;
        // while(temp!=null){
        //     if(set.contains(temp))return true;
        //     else{
        //         set.add(temp);
        //         temp=temp.next;
        //     }
        // }
        // return false;
        //this will take 0(n), n is the number of nodes

        //Two Pointer Approach
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast==slow)return true;
        }
        return false;
    }
}
