/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    int lengthCycle(ListNode head){
        ListNode f = head;
        ListNode s = head;
        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(f == s){
                ListNode temp = s;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != s);
                return length;
            }
        }
        return 0;
    }
    public ListNode detectCycle(ListNode head) {
        int l = 0;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                l = lengthCycle(slow);
                break;
            }
        }
        if(l == 0){
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while(l > 0){
            s = s.next;
            l--;
        }
        while(f != s){
            f = f.next;
            s = s.next;
        }
        return s;
    }
}