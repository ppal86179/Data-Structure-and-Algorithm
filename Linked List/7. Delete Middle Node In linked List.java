/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    Node deleteMid(Node head) {
        
    //1. BruteForce Approach
        // Node temp = head;
        // int count = 0;
        // while(temp!=null){
        //     temp=temp.next;
        //     count++;
        // }
        // temp = head;
        // int i = count/2;
        // while(i!=1){
        //     temp=temp.next;
        //     i--;
        // }
        // temp.next=temp.next.next;
        // return head;
        
    //2. Optimal Approach
        Node fast = head;
        Node slow = head;
        Node prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }
}
