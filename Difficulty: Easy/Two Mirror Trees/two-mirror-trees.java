// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Solution {
    List<List<Integer>> BFS(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l = q.size();
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < l; i++){
                Node node = q.poll();
                inner.add(node.data);
                if(node.left != null)
                q.offer(node.left);
                if(node.right != null)
                q.offer(node.right);
            }
            ans.add(inner);
        }
        return ans;
    }
    boolean areMirror(Node a, Node b) {
        // Your code here
        List<List<Integer>> l1 = BFS(a);
        List<List<Integer>> l2 = BFS(b);
        for(int i = 0; i < l2.size(); i++){
            Collections.reverse(l2.get(i));
        }
        if(l1.equals(l2))
        return true;
        else
        return false;
    }
}