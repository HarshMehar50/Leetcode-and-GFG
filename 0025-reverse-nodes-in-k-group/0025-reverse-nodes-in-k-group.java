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
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null){
            return head;
        }
        ListNode c = head;
        ListNode p = null;
        int l = length(head);
        int x = l/k;
        while(x > 0){
            ListNode last = p;
            ListNode newEnd = c;
            ListNode n = c.next;
            for(int i = 0; i < k && c != null; i++){
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