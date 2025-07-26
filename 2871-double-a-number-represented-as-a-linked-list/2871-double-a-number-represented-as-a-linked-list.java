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
    ListNode reverse(ListNode head) {
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
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = head;
        ListNode rev = reverse(dummy);
        ListNode temp = new ListNode(-1);
        temp.next = rev;
        int c = 0;
        while(rev != null){
            int pv = rev.val;
            int nv = ((2*pv)+c);
            rev.val = nv%10;
            c = nv/10;
            rev = rev.next;
        }
        if(c != 0){
        ListNode nn = new ListNode(c);
        ListNode temp1 = temp;
        while(temp1.next != null){
            temp1 = temp1.next;
        } 
        temp1.next = nn;
        }
        ListNode fans = reverse(temp.next);
        return fans;
    }
}