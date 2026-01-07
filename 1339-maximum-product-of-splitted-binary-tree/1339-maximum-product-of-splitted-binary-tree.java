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
    final int mod = 1000000007;
    long DFS(TreeNode node , List<Long> l){
        if(node == null)
        return 0;
        long left = DFS(node.left , l);
        long right = DFS(node.right , l);
        long s = left+right+node.val;
        l.add(s);
        return s;
    }
    public int maxProduct(TreeNode root) {
        List<Long> l = new ArrayList<>();
        long ts = DFS(root , l);
        long ans = 0;
        for(long x : l){
            ans = Math.max(ans , (ts-x)*x);
        }
        return (int)(ans%mod);
    }
}