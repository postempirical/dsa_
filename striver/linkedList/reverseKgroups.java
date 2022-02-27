// https://leetcode.com/problems/reverse-nodes-in-k-group/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy, pre = dummy, nex = dummy;
        int count = 0;
        
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        
        while (count >= k) {
            curr = pre.next;
            nex = curr.next;
            for (int i = 0; i < k - 1; i++) {
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            pre = curr;
            count = count - k;
        }
        return dummy.next;
    }
}
