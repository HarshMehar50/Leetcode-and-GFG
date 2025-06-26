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
    int ceil(TreeNode root , int x){
        int c = -1;
        TreeNode temp = root;
        while(temp != null){
            if(temp.val == x){
                return x;
            }
            if(x > temp.val)
            temp = temp.right;
            else{
                c = temp.val;
                temp = temp.left;
            }
        }
        return c;
    }
    int floor(TreeNode root , int x){
        int f = -1;
        TreeNode temp = root;
        while(temp != null){
            if(temp.val == x){
                return x;
            }
            if(x > temp.val){
                f = temp.val;
                temp = temp.right;
            }else
            temp = temp.left;
        }
        return f;
    }
    void inorder(TreeNode root , List<Integer> l){
        if(root == null)
        return;
        inorder(root.left , l);
        l.add(root.val);
        inorder(root.right , l);
    }
    int ceil(List<Integer> l , int x){
        int c = -1;
        int s = 0;
        int e = l.size()-1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m) == x)
            return x;
            if(x > l.get(m))
            s = m+1;
            else{
                c = l.get(m);
                e = m-1;
            }
        }
        return c;
    }
    int floor(List<Integer> l , int x){
        int s = 0;
        int e = l.size()-1;
        int f = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m) == x)
            return x;
            if(x > l.get(m)){
                f = l.get(m);
                s = m+1;
            }else
            e = m-1;
        }
        return f;
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        /*for(int i = 0; i < queries.size(); i++){
            int f = floor(root , queries.get(i));
            int c = ceil(root , queries.get(i));
            List<Integer> inner = new ArrayList<>();
            inner.add(f);
            inner.add(c);
            ans.add(inner);
        }
        return ans;*/
        List<Integer> l = new ArrayList<>();
        inorder(root , l);
        for(int i = 0; i < queries.size(); i++){
            int f = floor(l , queries.get(i));
            int c = ceil(l , queries.get(i));
            List<Integer> inner = new ArrayList<>();
            inner.add(f);
            inner.add(c);
            ans.add(inner);
        }
        return ans;
    }
}