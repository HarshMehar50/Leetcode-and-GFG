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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int c = 2;
            int l = q.size();
            List<Integer> currentLevel = new ArrayList<>(l);
            for(int i = 0; i < l; i++){
                TreeNode current = q.poll();
                currentLevel.add(current.val);
                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }
            }
            if(list.size()%2 == 0){
                list.add(currentLevel);
            }else{
                Collections.reverse((currentLevel));
                list.add(currentLevel);
            }
        }
        return list;
    }
}