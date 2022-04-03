class Solution {
    public ListNode sortList(ListNode head) {
        // recursive O(n) space solution
        if (head == null || head.next == null) return head;
        // apple slowfast approach to get mid
        // need the first mid node for even list now
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // break from mid
        prev.next = null;
        
        // recursive call 
        // this will keep call till there is only single node
        // then it will merge those node 
        // and continue to bigger sublists
        ListNode a = sortList(head);
        ListNode b = sortList(slow);
        
        //merge sorted halves
        return merge(a, b);
    }
    
    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            }
            else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        if (a != null) curr.next = a;
        else if (b != null) curr.next = b;
        // return head of merged list
        return dummy.next;
    }
}
