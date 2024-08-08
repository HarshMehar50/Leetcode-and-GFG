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
    int ans = Integer.MIN_VALUE;
    int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        left = Math.max(0 , left);
        right = Math.max(0 , right);
        int pathSum = left+right+root.val;
        ans = Math.max(ans , pathSum);
        return Math.max(left , right)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }
}