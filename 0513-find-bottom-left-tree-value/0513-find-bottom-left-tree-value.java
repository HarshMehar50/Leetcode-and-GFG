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
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return -1;
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
            list.add(currentLev);
        }
        List<Integer> ans = list.get(list.size()-1);
        return ans.get(0);
    }
}