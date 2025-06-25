/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    static int length(Node root){
        Node temp = root;
        int l = 0;
        while(temp != null){
            l++;
            temp = temp.next;
        }
        return l;
    }
    static Node intersectPoint(Node head1, Node head2) {
        // code here
        /*Node temp1 = head1;
        while(temp1 != null){
            Node temp2 = head2;
            while(temp2 != null){
                if(temp2 == temp1)
                return temp2;
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return null;*/
        int l1 = length(head1);
        int l2 = length(head2);
        Node temp1 = head1;
        Node temp2 = head2;
        if(temp1 == null || temp2 == null)
        return null;
        while(temp1 != temp2){
            if(temp1 != null)
            temp1 = temp1.next;
            else
            temp1 = head2;
            if(temp2 != null)
            temp2 = temp2.next;
            else
            temp2 = head1;
        }
        return temp1;
    }
}