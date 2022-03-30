// https://leetcode.com/problems/merge-two-sorted-lists/
class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        
        // create dummy list with 0 as dummy node
        ListNode dummy = new ListNode(0);
        // point curr at dummy node 0
        ListNode curr = dummy;
        
        while (a != null && b != null) {
            // point next of curr of lesser val
            // move smaller list head forward
            // move curr forward
            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
                curr = curr.next;
            }
            else {
                curr.next = b;
                b = b.next;
                curr = curr.next;
            }
        }
        
        // add remaining list
        if (a == null) curr.next = b;
        else if (b == null) curr.next = a;
        
        // dummy points at 0, point to its next for list start
        return dummy.next;
    }
}

// in place

class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode dummyHead = new ListNode(0);        
        ListNode mover = dummyHead;
        
				// bring dummy, mover on smaller node
				// separate that node by adding null to mover next
        if (a.val < b.val) {
            dummyHead = a;
            mover = a;
            a = a.next;
            mover.next = null;
        }
        else {
            dummyHead = b;
            mover = b;
            b = b.next;
            mover.next = null;
        }
        
				// point mover to smaller val
				// move mover to smaller node
				// move smaller list node forward
				// always separate by adding null
        while (a != null && b != null) {
            if (a.val < b.val) {
                mover.next = a;
                mover = a;
                a = a.next;
            }
            else {
                mover.next = b;
                mover = b;
                b = b.next;
            }
            mover.next = null;
        }
        
				// add remaining list
        if (a == null) mover.next = b;
        else mover.next = a;
        
        return dummyHead;
    }
}
