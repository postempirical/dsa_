// Implementation of DLL and its common methods

class Program {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    // Time: O(1), Space: O(1)  
    public void setHead(Node node) {
      if (head == null) {
				head = node;
				tail = node;
				return;
			}
			insertBefore(head, node);
    }

    // Time: O(1), Space: O(1)  
    public void setTail(Node node) {
      if(tail == null) {
				setHead(node);
				return;
			}
			insertAfter(tail, node);
    }

    // Time: O(1), Space: O(1)  
    public void insertBefore(Node node, Node nodeToInsert) {
      if (nodeToInsert == head && nodeToInsert == tail) return;
			remove(nodeToInsert);
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;
			if (node.prev == null) head = nodeToInsert;
			else node.prev.next = nodeToInsert;
			node.prev = nodeToInsert;
    }

    // Time: O(1), Space: O(1)  
    public void insertAfter(Node node, Node nodeToInsert) {
      if (nodeToInsert == head && nodeToInsert == tail) return;
			remove(nodeToInsert);
			nodeToInsert.prev = node;
			nodeToInsert.next = node.next;
			if (node.next == null) tail = nodeToInsert;
			else node.next.prev = nodeToInsert;
			node.next = nodeToInsert;	
    }

    // Time: O(p), Space: O(1)  
    public void insertAtPosition(int position, Node nodeToInsert) {
      if (position == 1) {
				setHead(nodeToInsert);
				return;
			}
			Node node = head;
			int currentPos = 1;
			while (node != null && currentPos++ != position) node = node.next;
			if (node != null) insertBefore(node, nodeToInsert);
			else setTail(nodeToInsert);
    }

    // Time: O(n), Space: O(1)  
    public void removeNodesWithValue(int value) {
      Node node = head;
			while (node != null) {
				Node nodeToRemove = node;
				node = node.next;
				if(nodeToRemove.value == value) remove(nodeToRemove);
			}
    }
    
    // Time: O(1), Space: O(1)  
    public void remove(Node node) {
      if (node == head) head = head.next;
			if (node == tail) tail = tail.prev;
			if (node.prev != null) node.prev.next = node.next;
			if (node.next != null) node.next.prev = node.prev;;
			node.prev = null;
			node.next = null;
    }

    // Time: O(n), Space: O(1)  
    public boolean containsNodeWithValue(int value) {
      Node node = head;
			while (node != null && node.value != value) {
				node = node.next;
			}
			return node != null;
    }
  }

  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
