// https://leetcode.com/problems/reverse-linked-list/

//    prev curr head
//    1     2      3 
// 	 slide everyone ahead
// 	 put next of curr to prev
// 	 in the end head will be null
// 	 so point head to curr and return
  
class Solution {
    public ListNode reverseList(ListNode head) {
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
