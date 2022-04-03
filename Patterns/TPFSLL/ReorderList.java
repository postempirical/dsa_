class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        
        // break list into 2
        ListNode head2 = split(head);
        // reverse second list
        head2 = reverse(head2);
        // merge them back again
        merge(head, head2);
    }
    
    public ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // get middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // next of middle id second head
        ListNode head2 = slow.next;
        
        // break list
        slow.next = null;
        
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
    
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        
        while (curr1 != null && curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            
            curr1.next = curr2;
            curr2.next = next1;
            
            curr1 = next1;
            curr2 = next2; 
        }
        return head1;
    }
}
