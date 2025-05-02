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
        int l = 0;
        while(temp != null){
            temp = temp.next;
            l++;
        }
        return l;
    }
    public ListNode middleNode(ListNode head) {
        int l = length(head);
        ListNode node = head;
        if(l%2 != 0){
            for(int i = 0; i <= l/2-1; i++){
                node = node.next;
            }
        }else{
            for(int i = 0; i < l/2; i++){
                node = node.next;
            }
        }
        ListNode h = node;
        return h;
    }
}