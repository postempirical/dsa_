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
                // and points its next to right
                Node curr = q.poll();
                curr.next = rightnode;
                // update right to curr for next iteration
                rightnode = curr;
                // ilf a child exists push RIGHT FIRST THEN LEFT
                // right to left BFS
                if (curr.right != null) {
                    q.add(curr.right);
                    q.add(curr.left);
                }
            }
        }
        return root;
    }
}

// BFS optimised
// O(n) O(1)
