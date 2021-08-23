// Remove kth element from the end of LL

// [1] -> Time: O(n^2), Space: O(1)  
class Program {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    LinkedList second = head;
		LinkedList first = head;
		int i = 1;
		while (i <= k) { // k nodes ahead of f so =
			second = second.next;
			i++;
		}
    
		if (second == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
    
		while (second.next != null) {
			second = second.next;
			first = first.next;
		}
		first.next = first.next.next;
    
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
