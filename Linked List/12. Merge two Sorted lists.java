class LinkedList
{
    //Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
//Recursive Approach

        // if(head1==null)return head2;
        // if(head2==null)return head1;
        
        // if(head1.data<head2.data){
        //     head1.next = sortedMerge(head1.next,head2);
        //     return head1;
        // }
        // else{
        //     head2.next = sortedMerge(head1,head2.next);
        //     return head2;
        // }
        
//Iterative Approach

        if(head1==null)return head2;
        if(head2==null)return head1;
         
        Node dummy = new Node(-1);
        Node tail = dummy;
         
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            }     
            else{
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        if(head1==null){
            tail.next = head2;
        }
        else
        tail.next = head1;
        
        return dummy.next;
   } 
}
