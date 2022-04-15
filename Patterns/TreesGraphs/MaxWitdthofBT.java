class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        // create 2 queues for nodes and indices
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> q_index = new LinkedList<>();
        // add start value; root will start from index 1
        q.add(root);
        q_index.add(1);
        int max = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0, end = 0;
            
            for (int i = 0; i < size; i++) {
                // take out node as well as its index
                TreeNode node = q.poll();
                int index = q_index.poll();
                
                // if start or end of level, update them to index
                if (i == 0) start = index;
                if (i == size - 1) end = index;
                
                // go to next nevel in both queues
                if (node.left != null) {
                    q.add(node.left);
                    q_index.add(2 * index);
                }
                if (node.right != null) {
                    q.add(node.right);
                    q_index.add(2 * index + 1);
                }
            }
            // after loop end, start end will have val of last level
            // which will give us the max width
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}


// instead of 2 queues, can also create a pair class
class Pair {
    TreeNode node;
    int num;
    Pair(TreeNode node, int num) {
        this.node = node;
        this.num  = num;
    }
}
    
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            // make mini as 0 at start
            int mini = q.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int index = q.peek().num - mini;
                TreeNode node = q.peek().node;
                q.poll();
                
                if (i == 0) first = index;
                if (i == size - 1) last = index;
                
                if (node.left != null)
                    q.add(new Pair(node.left, index * 2 + 1));
                if (node.right != null)
                    q.add(new Pair(node.right, index * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
