// METHOD 1
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next.next;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}


// METHOD 2
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        
        int len = 1;
        ListNode curr = head;
        
        // find length of linkedlist
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        
        // bring back curr to head
        // bring curr to the prev node of middle node
        curr = head;
        for (int i = 0; i < len / 2 - 1; i++) {
            curr = curr.next;
        }
        
        // update connections
        curr.next = curr.next.next;
        return head;
    }
}
