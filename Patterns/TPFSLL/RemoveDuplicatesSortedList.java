class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            // if its last node break
            if (curr.next == null) break;
            
            // break link of equal value
            if (curr.val == curr.next.val) curr.next = curr.next.next;
            else curr = curr.next;
        }
        return head;
    }
}
