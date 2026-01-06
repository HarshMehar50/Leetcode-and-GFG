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
    int max(List<Integer> l){
        int m = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < l.size(); i++){
            if(l.get(i) > m){
                m = l.get(i);
                index = i;
            }
        }
        return index;
    }
    public int maxLevelSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l = q.size();
            int s = 0;
            for(int i = 0; i < l; i++){
                TreeNode current = q.poll();
                s += current.val;
                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }
            }
            list.add(s);
        }
        return max(list)+1;
    }
}