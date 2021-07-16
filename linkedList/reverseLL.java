// Reverse a LL

// [1] -> Time: O(n), Space: O(1)  
class Program {
  public static LinkedList reverseLinkedList(LinkedList head) {
		// sliding(3) -- last >> mid >> lead
    LinkedList lead = head;
		LinkedList mid = null;
		LinkedList last = null; 
    while (lead != null) {
			last = mid;
			mid = lead;
			lead = lead.next;
			mid.next = last;
		}
		head = mid;
		return mid;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
