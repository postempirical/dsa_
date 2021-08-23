// Delete duplicates in a sorted linked list

// [1] -> Time: O(n), Space: O(1)  
class Program {
  // This is an input class
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
		LinkedList current = linkedList;
		while (current != null) {
			LinkedList distinct = current.next;
			while (distinct != null && distinct.value == current.value) {
				distinct = distinct.next;
			}
			current.next = distinct;
			current = distinct;
		}
    return linkedList;
  }
}
