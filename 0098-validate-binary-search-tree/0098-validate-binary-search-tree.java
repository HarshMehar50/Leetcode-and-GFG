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
    boolean solve(TreeNode root , long min , long max){
        if(root == null)
        return true;
        boolean c = false;
        if(root.val < max && root.val > min)
        c = true;
        boolean ans = c&&solve(root.left , min , root.val)&&solve(root.right , root.val , max);
        return ans;
    }
    public boolean isValidBST(TreeNode root) {
        return solve(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }
}