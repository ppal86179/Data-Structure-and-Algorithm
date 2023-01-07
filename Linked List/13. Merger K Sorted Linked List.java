Using Min heap data structure inserting node in logk time and removing min node in logk time and creating new linkedlist
(k is the size of heap)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue<ListNode> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>() {
        @Override
        public int compare(ListNode k1, ListNode k2)
        {
            if (k1.val > k2.val)
                return 1;
            else if (k1.val < k2.val)
                return -1;
            return 0;
        }
    });
        for(int i=0; i<lists.length; i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        //In pqriorityQueue
                        //        [1]-->4-->5
                        //     /      \
                        //    /        \
                        // [1]->3->4   [2]->6
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(!pq.isEmpty()){
            ListNode temp = pq.peek();
            tail.next = temp;
            tail = temp;
            pq.poll();
            if(temp.next!=null){
                pq.add(temp.next);
            }
        }
        return dummy.next;
    }
}

Time complexity:
Nlogk , N is the total no. of nodes

Space complexity:
O(k)
