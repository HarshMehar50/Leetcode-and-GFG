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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int r = 0;
        int t = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                TreeNode c = q.poll();
                int x = c.val;
                if(r%2 == 0){
                    if(x%2 == 1 && t < x){
                        t = x;
                    }else
                        return false;
                } else{
                    if(x%2 == 0 && t > x){
                        t = x;
                    }else
                        return false;
                }
                if(c.left != null)
                    q.offer(c.left);

                if(c.right != null)
                    q.offer(c.right);
            }
            r++;
            t = ((r%2)==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return true;
    }
}