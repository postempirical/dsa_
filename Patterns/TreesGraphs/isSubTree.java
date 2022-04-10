class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        // if both trees are identical - true
        if (isSameTree(root, subRoot)) return true;
        // move to new branches with their node as new root
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    // will compare subroot with new root being fed
    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val == subRoot.val) 
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        return false;
    }
}
