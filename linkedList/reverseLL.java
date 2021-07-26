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
	
// [2] -> Time: O(n), Space: O(1)  
	public static LinkedList reverseLinkedList(LinkedList head) {
	// sliding(2) -- previous >> current
    LinkedList current = head;
		LinkedList previous = null; 
    while (current != null) {
			LinkedList nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}
		return previous;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
