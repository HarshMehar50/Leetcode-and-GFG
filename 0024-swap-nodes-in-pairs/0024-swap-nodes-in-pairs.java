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
    public ListNode swapPairs(ListNode head) {
        /* if(head == null || head.next == null){
            return head;
        }
        ListNode second = head.next;
        ListNode third = second.next;
        second.next = head;
        head.next = swapPairs(third);
        return second;*/
        if(head == null){
            return head;
        }
        ListNode c = head;
        ListNode p = null;
        int l = length(head);
        int x = l/2;
        while(x > 0){
            ListNode last = p;
            ListNode newEnd = c;
            ListNode n = c.next;
            for(int i = 0; i < 2 && c != null; i++){
                c.next = p;
                p = c;
                c = n;
                if(n != null){
                    n = n.next;
                }
            }
            if(last != null){
                last.next = p;
            }else{
                head = p;
            }
            newEnd.next = c;
            p = newEnd;
            x--;
        }
        return head;
    }
}