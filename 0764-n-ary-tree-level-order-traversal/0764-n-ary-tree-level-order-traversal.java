/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l = q.size();
            List<Integer> currentLev = new ArrayList<>();
            for(int i = 0; i < l; i++){
                Node current = q.poll();
                currentLev.add(current.val);
                while(!current.children.isEmpty()){
                    q.offer(current.children.get(0));
                    current.children.remove(0);
                }
            }
            list.add(currentLev);
        }
        return list;
    }
}