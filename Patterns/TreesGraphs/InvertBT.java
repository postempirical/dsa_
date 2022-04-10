// DFS
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // store left, right of root
        TreeNode left = root.left;
        TreeNode right = root.right;
        // swap left and right roots
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}

//BFS
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            // swap nodes
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        return root;
    }
}
