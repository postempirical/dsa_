class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // add 1 to max as depth will atleast be 1 if root is not null
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
