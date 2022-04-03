class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        // get length of list
        // need curr to be at last node in the end 
        // to point it to head later on
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        
        // point curr(last node) to list start
        curr.next = head;
        k = k % length;
        
        // remove the len-k node and point new head
        int x = length - k;
        while (x > 0) {
            curr = curr.next;
            x--;
        }
        // point head and kill link
        head = curr.next;
        curr.next = null;
        return head;
    }
}
