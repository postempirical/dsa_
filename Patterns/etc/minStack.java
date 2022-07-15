class MinStack {
    class Node {
        int value; 
        int min; 
        Node next;
        
        Node (int value, int min) {
            this.value = value;
            this.min = min;
            next = null;
        }
    }
    
    Node head;
    
    public void push(int val) {
        if (head == null) head = new Node(val, val);
        else {
            Node node = new Node(val, Math.min(val, head.min));
            node.next = head;
            head = node;
        }
    }
    
    public void pop() {
        if (head != null) head = head.next;
    }
    
    public int top() {
        if (head != null) return head.value;
        else return -1;
    }
    
    public int getMin() {
        if (head != null) return head.min;
        else return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
