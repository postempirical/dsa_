class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode head2 = mid(head);
        head2 = reverse(head2);
        
        // now check palindrome
        while(head2 != null) {
            if (head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
    
    public ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // get middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // next of middle is second head
        ListNode head2 = slow.next;
        
        return head2;
    }
    
    public ListNode reverse(ListNode head2) {
        ListNode prev = null;
        ListNode mid = null;

        while (head2 != null) {
            prev = mid;
            mid = head2;
            head2 = head2.next;
            mid.next = prev;
        }
        head2 = mid;
        return head2;
    }
}
