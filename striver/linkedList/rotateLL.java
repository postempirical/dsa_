// https://leetcode.com/problems/rotate-list/
// Tc = n + (n-n%k)

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 1; // atleast one node is there
        ListNode curr = head;
        
        // finding length of list
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }
        
        curr.next = head;
        k = k % len; // if k > len
        k = len - k; // iterate to last node of new list
        while (k > 0) {
            curr = curr.next;
            k--;
        }
        
        head = curr.next; 
        curr.next = null;
        return head;   
    }
}
