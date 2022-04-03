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


// LIKE REORDER LIST
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
