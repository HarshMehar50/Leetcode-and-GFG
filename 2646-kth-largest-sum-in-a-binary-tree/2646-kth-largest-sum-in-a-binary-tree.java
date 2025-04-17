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
    long sum(List<Long> l){
        long s = 0;
        for(int i = 0; i < l.size(); i++){
            s = s + l.get(i);
        }
        return s;
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<List<Long>> list = new ArrayList<>();
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l = q.size();
            List<Long> current = new ArrayList<>(l);
            for(int i = 0; i < l; i++){
                TreeNode currentNode = q.poll();
                current.add((long)currentNode.val);
                if(currentNode.left != null){
                    q.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }
            }
            list.add(current);
        }
        List<Long> ans = new ArrayList<>();
        for(List<Long> j : list){
            ans.add(sum(j));
        }
        if(k > ans.size()){
            return -1;
        }
        Collections.sort(ans);
        return ans.get(ans.size()-k);
    }
}