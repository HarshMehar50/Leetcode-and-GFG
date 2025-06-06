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
    /* int solve(List<Integer> list){
        int[] dp = new int[list.size()+2];
        for(int i = list.size()-1; i >= 0; i--){
            dp[i] = Math.max(list.get(i)+dp[i+2] , dp[i+1]);
        }
        return dp[0];
    }*/
    int solve(TreeNode root , HashMap<TreeNode  , Integer> dp){
        if(root == null){
            return 0;
        }
        if(dp.containsKey(root)){
            return dp.get(root);
        }
        int ans = 0;
        if(root.left != null){
            ans += solve(root.left.left , dp)+solve(root.left.right , dp);
        }
        if(root.right != null){
            ans += solve(root.right.left , dp)+solve(root.right.right , dp);
        }
        ans = Math.max(ans+root.val , solve(root.left , dp)+solve(root.right , dp));
        dp.put(root , ans);
        return ans;
    }
    public int rob(TreeNode root) {
        /*List<Integer> list = new ArrayList<>();
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
        return solve(list);*/
        HashMap<TreeNode  , Integer> dp = new HashMap<>();
        return solve(root , dp);
    }
}