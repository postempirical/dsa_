class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return solve(root.left, root.right);
    }
    
    private boolean solve(TreeNode left, TreeNode right) {
        // base case
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        
        if (left.val != right.val) return false;
        
        return solve(left.left, right.right) && solve(left.right, right.left);
    }
}
