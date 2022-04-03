class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = null;
        while (head != null) {
            // slide
            prev = curr;
            curr = head;
            head = head.next;
            // break link of curr 
            curr.next = prev;
        }
        // head is null, point it to curr again
        head = curr;
        return head;
    }
}
