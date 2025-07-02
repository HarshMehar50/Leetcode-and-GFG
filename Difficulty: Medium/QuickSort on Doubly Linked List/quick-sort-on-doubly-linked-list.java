/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        this.next = null;
        this.prev = null;
    }
}
*/

class Solution {
    public DLLNode getTail(DLLNode cur) {
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public DLLNode partition(DLLNode head, DLLNode end, DLLNode[] newHead,
                             DLLNode[] newEnd) {
        DLLNode pivot = end;
        DLLNode prev = null, cur = head, tail = pivot;

        while (cur != pivot) {
            if (cur.data < pivot.data) {
                if (newHead[0] == null) {
                    newHead[0] = cur;
                }
                prev = cur;
                cur = cur.next;
            } else {
                if (prev != null) {
                    prev.next = cur.next;
                }
                if (cur.next != null) {
                    cur.next.prev = prev;
                }
                DLLNode tmp = cur.next;
                cur.next = null;
                tail.next = cur;
                cur.prev = tail;
                tail = cur;
                cur = tmp;
            }
        }

        if (newHead[0] == null) {
            newHead[0] = pivot;
        }

        newEnd[0] = tail;

        return pivot;
    }

    public DLLNode quickSortRecur(DLLNode head, DLLNode end) {
        if (head == null || head == end) {
            return head;
        }

        DLLNode[] newHead = {null};
        DLLNode[] newEnd = {null};

        DLLNode pivot = partition(head, end, newHead, newEnd);

        if (newHead[0] != pivot) {
            DLLNode tmp = newHead[0];
            while (tmp.next != pivot) {
                tmp = tmp.next;
            }
            tmp.next = null;
            pivot.prev = null;

            newHead[0] = quickSortRecur(newHead[0], tmp);

            tmp = getTail(newHead[0]);
            tmp.next = pivot;
            pivot.prev = tmp;
        }

        pivot.next = quickSortRecur(pivot.next, newEnd[0]);
        if (pivot.next != null) {
            pivot.next.prev = pivot;
        }

        return newHead[0];
    }

    public DLLNode quickSort(DLLNode head) {
        DLLNode tail = getTail(head);
        return quickSortRecur(head, tail);
    }
}