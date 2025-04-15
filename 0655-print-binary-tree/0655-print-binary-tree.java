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
    class Node{
    TreeNode node;
        int r;
        int c;
        public Node(TreeNode node , int r , int c){
            this.node = node;
            this.r = r;
            this.c = c;
        }
    }
    int height(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l = q.size();
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < l; i++){
                TreeNode node = q.poll();
                inner.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            list.add(inner);
        }
        return list.size()-1;
    }
    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        List<List<String>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        for(int i = 0; i <= h; i++){
            List<String> inner = new ArrayList<>((int)(Math.pow(2 , h+1)-1));
            for(int j = 0; j < (int)(Math.pow(2 , h+1)-1); j++){
                inner.add("");
            }
            ans.add(inner);
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root , 0 , (ans.get(0).size()-1)/2));
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                TreeNode node = q.peek().node;
                int r = q.peek().r;
                int c = q.peek().c;
                q.poll();
                ans.get(r).set(c , Integer.toString(node.val));
                if(node.left != null){
                    q.offer(new Node(node.left , r+1 , (int)(c-Math.pow(2 , h-r-1))));
                }
                if(node.right != null){
                    q.offer(new Node(node.right , r+1 , (int)(c+Math.pow(2 , h-r-1))));
                }
            }
        }
        return ans;
    }
}