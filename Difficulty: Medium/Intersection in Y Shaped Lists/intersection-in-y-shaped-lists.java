/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        HashMap<Node , Node> map1 = new HashMap<>();
        Node temp1 = head1;
        while(temp1 != null){
            map1.put(temp1.next , temp1);
            temp1 = temp1.next;
        }
        HashMap<Node , Node> map2 = new HashMap<>();
        Node temp2 = head2;
        while(temp2 != null){
            map2.put(temp2.next , temp2);
            temp2 = temp2.next;
        }
        for(Node x : map1.keySet()){
            if(map2.containsKey(x) && map1.get(x) != map2.get(x))
            return x;
        }
        return null;
    }
}