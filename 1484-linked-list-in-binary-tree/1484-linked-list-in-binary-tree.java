/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
   /* TreeNode find(TreeNode root , int value){
        if(root != null){
            if(root.val == value){
                return root;
            }else{
                find(root.left , value);
                find(root.right , value);
            }
        }
        return null;
    }*/
    /*boolean recursion(ListNode head , TreeNode root){
        int headValue = head.val;
        int treeValue = root.val;
        if(headValue == treeValue && head != null && root != null){
            return true;
        }
        return recursion(head.next , root.left)||recursion(head.next , root.right); 
    }*/
    boolean solve(ListNode head , TreeNode root){
        if(head == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(root.val != head.val){
            return false;
        }
           boolean left = solve(head.next , root.left);
           boolean right = solve(head.next , root.right);
           return left||right;
        
    }
    public boolean isSubPath(ListNode head , TreeNode root) {
       /* TreeNode start = find(root , head.val);
        return recursion(head , start);*/
        if(root == null){
            return false;
        }
        if(solve(head , root)){
            return true;
        }
        boolean left = isSubPath(head , root.left);
        boolean right = isSubPath(head , root.right);
        return left||right;
    }
}