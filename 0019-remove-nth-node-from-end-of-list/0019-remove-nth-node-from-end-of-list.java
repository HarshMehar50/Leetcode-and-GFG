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
    int size(ListNode head){
        int l = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            l++;
        }
        return l;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int s = size(head);
        ListNode node = head;
        if (s == n) {
            return head.next;
        } else {
            for (int i = 0; i < s - n - 1; i++) {
                node = node.next;
            }
            if (node != null && node.next != null)
                node.next = node.next.next;
            return head;
        }
    }
}