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
    int daimeter = 0;
    int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int d = leftHeight + rightHeight + 1;
        daimeter = Math.max(d , daimeter);
        return Math.max(leftHeight, rightHeight)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return daimeter-1;
    }
}