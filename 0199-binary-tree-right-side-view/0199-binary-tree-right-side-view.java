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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l = q.size();
            List<Integer> currentLev = new ArrayList<>();
            for(int i = 0; i < l; i++){
                TreeNode current = q.poll();
                currentLev.add(current.val);
                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }
            }
            ans.add(currentLev.get(l-1));
        }
        return ans;
    }
}