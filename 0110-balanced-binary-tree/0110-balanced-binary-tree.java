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
    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    boolean solve(TreeNode root){
        if(root == null)
        return true;
        boolean ans = (Math.abs(height(root.right)-height(root.left)) <= 1)&&solve(root.right)&&solve(root.left);
        return ans;
    }
    public boolean isBalanced(TreeNode root) {
        return solve(root);
    }
}