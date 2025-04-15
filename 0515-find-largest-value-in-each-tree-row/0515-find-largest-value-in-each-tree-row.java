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
    public List<Integer> largestValues(TreeNode root) {
        /*List<List<Integer>> list = new ArrayList<>();
       List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.isEmpty()){
            int l = q.size();
            List<Integer> currentLev = new ArrayList<>(l);
            for(int i = 0; i < l; i++){
                TreeNode current = q.poll();
                currentLev.add(current.val);
                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }
            }
            list.add(currentLev);
        }
        for(List<Integer> l : list){
            Collections.sort(l);
            ans.add(l.get(l.size()-1));
        }
        return ans;*/
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentLength = queue.size();
            int currMax = Integer.MIN_VALUE;
            for (int i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                currMax = Math.max(currMax, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(currMax);
        }
        return ans;
    }
}