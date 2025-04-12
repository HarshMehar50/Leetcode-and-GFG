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
    int solve(TreeNode root , int s){
        if(root == null){
            return 0;
        }
        s = s*10+root.val;
        if(root.right == null && root.left == null){
            return s;
        }
        return solve(root.left , s)+solve(root.right , s);
    }
    public int sumNumbers(TreeNode root) {
        return solve(root , 0);
    }
}