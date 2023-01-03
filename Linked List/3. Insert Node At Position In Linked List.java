given position index and data value
insert data Node at that position index(0-based index)

Example:- 10->20->30->40 , position = 3 , data = 80
output:-  10->20->30->80->40
 
  
class Node{
   int data;
   Node next;
  
   Node(int data){
    this.data=data;
    next = null;
   }
}

class Solution{
  
  public static Node Insert(Node head,int data,int pos){
    //1.create node with given data
    Node newNode = new Node(data);
    
    //4.if given position is starting means pos = 0 
    if(pos==0){
      newNode.next = head;
      return newNode;
//            or
//       head = newNode;
//       return head;
    }
    
    //2.go to that pos index by traversing
    Node temp = head;
    while(pos!=1){
      temp = temp.next;
      pos--;
    }
    
    //3.connect newNode with next pointed node and current node next to newNode
    newNode.next = head.next;
    head.next = newNode;
    return head;
  }
}



//Recursion
Example:- 10->20->30->40 , position = 3 , data = 80
  
  break into small problem  (10)->    (20->30->40)
                             |              |
                       small problem    big problem
                       
small problem = if we want to insert Node at starting index
big problem  = handle by recursion from pos-1
  
class Solution{
       public static Node Insert(Node head,int pos,int data){
         Node newNode = new Node(data);
         if(head==null)
           return head;
         if(pos==0){
             newNode.next = head;
             return newNode;
          }
         head.next = Insert(head.next,pos-1,data);
         return head;
       }

}
