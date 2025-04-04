/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<TreeNode>> BFS(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<TreeNode>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int l = q.size();
            List<TreeNode> inner = new ArrayList<>();
            for(int i = 0; i < l; i++){
                TreeNode node = q.poll();
                inner.add(node);
                if(node.right != null)
                q.offer(node.right);
                if(node.left != null)
                q.offer(node.left);
            }
            ans.add(inner);
        }
        return ans;
    }
    TreeNode LCA(TreeNode root , TreeNode node1 , TreeNode node2){
        if(root == null)
        return null;
        if(root == node1 || root == node2)
        return root;
        TreeNode left = LCA(root.left , node1 , node2);
        TreeNode right = LCA(root.right , node1 , node2);
        if(left != null && right != null)
        return root;
        if(left != null)
        return left;
        else
        return right;  
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null)
        return null;
        if(root.right == null && root.left == null)
        return root; 
        List<List<TreeNode>> list = BFS(root);
        List<TreeNode> last = list.get(list.size()-1);
        if(last.size() == 1)
        return last.get(0);
        TreeNode ans = LCA(root , last.get(0) , last.get(1)); 
        for(int i = 2; i < last.size(); i++){
            ans = LCA(root , ans , last.get(i));
        }
        return ans;
    }
}