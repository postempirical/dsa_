// 

// brute O(m*n)
ListNode ptr1=headA;
ListNode ptr2=headB;
  while(ptr1!=null) {
     ptr2=headB;
     while(ptr2!=null) {
         if(ptr1==ptr2) return(ptr2);
            ptr2=ptr2.next;
        }
        ptr1=ptr1.next;
    }
return null;


// hash O(m+n) sc-O(n)
while ( headA != null ) {
        nodeVisit.add(headA);
        headA = headA.next;
    }
    
 while ( headB != null ) {
     if ( nodeVisit.contains(headB) return headB;
     else headB = headB.next;
 }
return null;
         
         
//  O(m) + O(m-n) + O(n)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // get lengths of lists
        int lenA = length(headA);
        int lenB = length(headB);
        
        // get two pointers on heads
        ListNode d1 = headA;
        ListNode d2 = headB;
        
        // move larger len dummy till len difference
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) d1 = d1.next;
        }
        else {
            for (int i = 0; i < lenB - lenA; i++) d2 = d2.next;
        }
        
        // now move both together till collision
        while (d1 != d2) {
            d1 = d1.next;
            d2 = d2.next;
        }
        return d1;
    }
    
    public int length(ListNode node) {
        int len = 0; 
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}
