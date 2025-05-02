/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        for (Node curr = head; curr != null; curr = curr.next)
            if (curr.child != null) {

                Node cachedNext = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                Node tail = curr.next;

                while (tail.next != null) {
                    tail = tail.next;
                }

                tail.next = cachedNext;

                if (cachedNext != null)
                    cachedNext.prev = tail;
            }

        return head;
    }
}