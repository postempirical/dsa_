// https://leetcode.com/problems/palindrome-linked-list/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        
        // find mid
        // mid must be first elem in case of even
        // so that we can pass slow.next as head
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse right half
        // passing slow.next as head to rev func
        slow.next = reverse(slow.next);
        
        // bring slow to second half
        slow = slow.next;
        
        // check equality of halfs
        while(slow != null) {
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
       ListNode prev = null; ListNode curr = null;
        while (head != null) {
            prev = curr;
            curr = head;
            head = head.next;
            curr.next = prev;
        }
        head = curr;
        return curr;
    }
}
