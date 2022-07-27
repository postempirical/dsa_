// BFS
// O(n) space and time
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            // initially set right to null
            Node rightnode = null;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                // pop a node from current level
                // and point its next to right
                Node curr = q.poll();
                curr.next = rightnode;
                
                // update right to curr for next iteration
                rightnode = curr;
                
                // if a child exists push RIGHT FIRST THEN LEFT
                // right to left BFS
                // check only for right, as its a complete binary tree
                // so if right is non null, then left will also be non null
                if (curr.right != null) {
                    q.add(curr.right);
                    q.add(curr.left);
                }
            }
        }
        return root;
    }
}

// PART 2
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int n = q.size();
            Node prev = null;
            
            for (int i = 0; i < n; i++) {
                // take out curr node
                Node curr = q.poll();
                
                // if prev is not null just point prev's next to curr
                if (prev != null) prev.next = curr;
                
                // bring prev to curr
                prev = curr;
                
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return root;
    }
}        

