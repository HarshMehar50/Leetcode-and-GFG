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
    int BS(List<Integer> l , int x){
        int s = 0;
        int e = l.size()-1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m) == x)
            return m;
            if(l.get(m) > x)
            e = m-1;
            else
            s = m+1;
        }
        return -1;
    }
    void inorder(TreeNode root , List<Integer> l){
        if(root == null)
        return;
        inorder(root.left , l);
        l.add(root.val);
        inorder(root.right , l);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();
        inorder(root , l);
        for(int i = 0; i < l.size(); i++){
            if(BS(l , k-l.get(i)) != -1 && BS(l , k-l.get(i)) != i)
            return true;
        }
        return false;
    }
}