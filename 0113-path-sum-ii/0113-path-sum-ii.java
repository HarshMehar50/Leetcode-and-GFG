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
    void solve(TreeNode root, int targetSum , List<List<Integer>> list , List<Integer> inner){
        if(root == null){
            return;
        }
        inner.add(root.val);
        if(root.val == targetSum && root.left == null && root.right == null){
            if(!inner.isEmpty())
                list.add(new ArrayList<>(inner));
        }else{
            solve(root.left , targetSum-root.val , list , inner);
            solve(root.right , targetSum-root.val , list , inner);
        }
        inner.remove(inner.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        solve(root , targetSum , list , inner);
        return list;
    }
}