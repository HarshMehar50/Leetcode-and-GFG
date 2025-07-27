/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        if(root == null)
        return new ArrayList<>();
        // code here
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l = q.size();
            ArrayList<Integer> inner = new ArrayList<>();
            for(int i = 0; i < l; i++){
                Node node = q.poll();
                inner.add(node.data);
                if(node.left != null)
                q.offer(node.left);
                if(node.right != null)
                q.offer(node.right);
            }
            if(!inner.isEmpty())
            ans.add(inner.get(0));
        }
        return ans;
    }
}