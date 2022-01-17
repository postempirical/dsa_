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
