// Merge 2 sorted LL maintaing the sort order

// [1] -> Time: O(m+n), Space: O(1)  
class Program {
  public static class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
    LinkedList headThree = null;
		LinkedList last = null;
		// storing head values for final comparison
		LinkedList one = headOne;
		LinkedList two = headTwo;
		
		if (headOne.value < headTwo.value) {
			headThree = headOne;
			last = headOne;
			headOne = headOne.next;
			headThree.next = null;
		}
		else {
			headThree = headTwo;
			last = headTwo;
			headTwo = headTwo.next;
			headThree.next = null;
		}
		
		while (headOne != null && headTwo != null) {
			if (headOne.value < headTwo.value) {
				last.next = headOne;
				last = headOne;
				headOne = headOne.next;
				last.next = null;
			}
			else {
				last.next = headTwo;
				last = headTwo;
				headTwo = headTwo.next;
				last.next = null;
			}
		}
		
		if (headOne != null) last.next = headOne;
		else last.next = headTwo;
    return one.value < two.value ? one : two;
  }
}
