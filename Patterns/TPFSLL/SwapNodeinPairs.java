class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = first.next;
            // d-1-2-3-4
            curr.next = second; // d->2
            first.next = second.next; // 1->3
            second.next = first; // 2->1
            curr = first; // curr = 1
            // d-2-1-3-4
        }
        return dummy.next;
    }
}
