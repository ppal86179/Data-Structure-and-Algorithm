Input: 9->0->5->1->6->1->2->0->5->0
Output: 5 2 9 5 6

Each integer input is accompanied by an indicator which can either be 0 or 1. If it is 0, 
insert the integer in the beginning of the link list. If it is 1, insert the integer at the end of the link list. 
  
  class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution
{
    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x)
    {
        // code here
        Node n = new Node(x);
        if(head==null){
            n.next=head;
            head=n;
        }

        else{
            n.next=head;
            head=n;
        }
        return head;
    }
    
    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x)
    {
        // code here
        Node n = new Node(x);
        if(head==null){
            n.next=head;
            head=n;
        }

        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next=n;
        n.next=null;
             
        return head;
    }

    
}
