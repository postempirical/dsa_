class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // point dummy to head
        // curr starts from dummy
        // need dummy to keep track of head
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        
        while (curr.next != null) {
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        }
        return dummy.next;
    }
}
