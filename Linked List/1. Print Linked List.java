/* Node is defined as
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution
{
    void display(Node head)
    {
        //add code here.
        if(head==null)
        System.out.print(head);
        while(head!=null){
            System.out.print(head.data + " ");
            head=head.next;
        }
    }
}
