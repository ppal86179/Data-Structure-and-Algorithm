/* Linklist node structure
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
/*You are required to complete below method*/
class GfG
{
    Node deleteNode(Node head, int x)
    {
        Node temp = head;
        if(x==1)
        return head.next;
        while(x!=2){
            temp = temp.next;
            x--;
        }
        if(temp.next.next==null){
            temp.next=null;
            return head;
        }
        else{
        temp.next = temp.next.next;
        return head;
        }
    }
}
