class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        // if reached a leaf node, check if sum is equal to value
        if (root.left == null && root.right == null) return sum == root.val;
        
        // otherwise go to both branches recursively
        // calculate reamaining sum to pass instead of original sum
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
