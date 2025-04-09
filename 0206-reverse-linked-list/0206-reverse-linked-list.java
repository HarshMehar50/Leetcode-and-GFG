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
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode c = head;
        ListNode p = null;
        ListNode n = c.next;
        while(c != null){
            c.next = p;
            p = c;
            c = n;
            if(n != null){
                n = n.next;
            }
        }
        return p;
    }
}