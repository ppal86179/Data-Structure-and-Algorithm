/*
class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/
//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
        //1. Swap data
         del.data = del.next.data;
        //2. create link
         del.next = del.next.next;
    }
}
