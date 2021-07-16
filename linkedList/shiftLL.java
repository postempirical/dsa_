// Shift elements by k (if K < 0 shift opposite)

// [1] -> Time: O(n), Space: O(1)  
class Program {
  public static LinkedList shiftLinkedList(LinkedList head, int k) {
    int length = 1;
		LinkedList tail = head; 
    
		// finding tail of list
		while (tail.next != null) { 
			tail = tail.next;
			length++;
		}
		
		int offset = Math.abs(k) % length;
		if (offset == 0) return head; // no shifting takes place
		int newTailPos = k > 0 ? length - offset : offset;
		LinkedList newTail = head;
		
		//finding newtail for shifting 
    for (int i = 1; i < newTailPos; i++) {
			newTail = newTail.next; 
		}
    
		// 0 -> 1 -> 2 -> [3] --(newtail) -> 4 -> [5] --(tail)
		// k = 2
		// (newHead) -- [4] -> 5 -> 0 -> 1 -> 2 -> [3] -- (newtail.next = null)
		
		LinkedList newHead = newTail.next; 
		newTail.next = null;
		tail.next = head;
		return newHead;
  }

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}
