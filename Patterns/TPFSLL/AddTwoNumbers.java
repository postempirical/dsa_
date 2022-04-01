class Solution {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        
        // keep going if either is non null or carry is not 0
        while (a != null || b != null || carry != 0) {
            int sum = 0;
            
            // add values and carry to sum
            if (a != null) {
                sum += a.val;
                a = a.next;
            }
            if (b != null) {
                sum += b.val;
                b = b.next;
            }
            // add carry and update carry
            sum += carry;
            carry = sum / 10;
            
            // create new node and point curr to it
            // then move curr forward
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}
