// https://leetcode.com/problems/merge-two-sorted-lists/

class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode preHead = new ListNode(0);
        ListNode mover = preHead;
        
        while (a != null && b != null) {
            if (a.val > b.val) {
                mover.next = b;
                b = b.next;
            }
            else {
                mover.next = a;
                a = a.next;
            }
            mover = mover.next;
        }
        
        if (a == null) mover.next = b;
        else mover.next = a;
        
        return preHead.next;
    }
}

// in place

class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode dummyHead = new ListNode(0);        
        ListNode mover = dummyHead;
        
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
        
        if (a == null) mover.next = b;
        else mover.next = a;
        
        return dummyHead;
    }
}
