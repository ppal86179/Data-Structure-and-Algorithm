/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution
{
    int getMiddle(Node head)
    {
    //Bruteforce approach
        //  Node temp = head;
        //  int count=0;
        //  while(temp!=null){
        //      temp=temp.next;
        //      count++;
        //  }
        //  int i = count/2+1;
        //  temp = head;
        //  while(i!=1){
        //      temp=temp.next;
        //      i--;
        //  }
        //  return temp.data;
    
    //Optimal approach (Tortoise hare Approach)
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.data;
    }
}
