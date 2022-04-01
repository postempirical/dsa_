class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // bring fast to nth node
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // make slow travel len-n dis
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // delete the node ahead of alow
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
