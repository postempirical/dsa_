class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean validate(TreeNode root, long min, long max) {
        if (root == null) return true;
        // root should be within PASSED max, min range
        // initially it will check for long limit values
        if (root.val >= max || root.val <= min) return false;
        // if within range, validate on left, right branches
        // left has vales < node value, right has values > node value
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}
