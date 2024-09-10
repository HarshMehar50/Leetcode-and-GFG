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
    int length(ListNode head){
        ListNode temp = head;
        int c = 0;
        while(temp != null){
            temp = temp.next;
            c++;
        }
        return c;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int l = length(head);
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        for(int i = 0; i < k%l; i++){
            ListNode temp = head;
            ListNode prev = null;
            while(temp.next != null){
                prev = temp;
                temp = temp.next;
            }
            ListNode node = temp;
            prev.next = null;
            node.next = head;
            head = node;
        }
        return head;
    }
}