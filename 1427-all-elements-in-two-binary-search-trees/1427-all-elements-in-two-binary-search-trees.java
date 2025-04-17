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
    List<Integer> bfs(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                TreeNode current = q.poll();
                list.add(current.val);
                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }
            }
        }
        return list;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = bfs(root1);
        List<Integer> list2 = bfs(root2);
        for(int i = 0; i < list2.size(); i++){
            list1.add(list2.get(i));
        }
        Collections.sort(list1);
        return list1;
    }
}