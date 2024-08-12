/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        List<List<Node>> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l = q.size();
            List<Node> inner = new ArrayList<>();
            for(int i = 0; i < l; i++){
                Node c = q.poll();
                if(c.left != null){
                    q.offer(c.left);
                }
                if(c.right != null){
                    q.offer(c.right);
                }
                inner.add(c);
            }
            list.add(inner);
        }
        for(List<Node> l : list){
            for(int i = 0; i < l.size()-1; i++){
                l.get(i).next = l.get(i+1);
            }
            l.get(l.size()-1).next = null;
        }
        return root;
    }
}