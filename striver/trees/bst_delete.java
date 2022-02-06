class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return helper(root);
        TreeNode originalRoot = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                }
                else {
                    root = root.left;
                }
            }
            else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                }
                else {
                    root = root.right;
                }
            }
        }
        return originalRoot;
    }
    
    public TreeNode helper(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        TreeNode rightChild = root.right;
        TreeNode lastRight = lastRightChild(root.left);
        lastRight.right = rightChild;
        return root.left;
    }
    
    public TreeNode lastRightChild(TreeNode root) {
        if (root.right == null) return root;
        return lastRightChild(root.right);
    }
}
