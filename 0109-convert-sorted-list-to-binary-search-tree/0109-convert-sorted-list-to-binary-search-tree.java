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
    TreeNode solve(ListNode head , HashMap<Integer , ListNode> map , int l , int r){
        if(l > r)
        return null;
        int m = l+(r-l)/2;
        TreeNode root = new TreeNode(map.get(m).val);
        root.left = solve(head , map , l , m-1);
        root.right = solve(head , map , m+1 , r);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        return null;
        HashMap<Integer , ListNode> map = new HashMap<>();
        int c = 0;
        ListNode temp = head;
        while(temp != null){
            map.put(c , temp);
            temp = temp.next;
            c++;
        }
        return solve(head , map , 0 , map.size()-1);
    }
}