public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
						// to find node where cycle start
// 						if (fast == slow) {
//                 fast = head;
//                 while (slow != fast) {
//                     slow = slow.next;
//                     fast = fast.next;
//                 }
//                 return slow;
//             }
        }
        return false;
    }
}
