// DFS
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // add 1 to max as depth will atleast be 1 if root is not null
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}


// BFS
public int maxDepth(TreeNode root) {
    if(root == null) return 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int count = 0;
    while(!q.isEmpty()) {
        int size = q.size();
        while(size-- > 0) {
            TreeNode node = q.poll();
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        count++;
    }
    return count;
}
