class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (height(root) == -1) return false;
        return true;
    }
    
    public int height(TreeNode node) {
        if (node == null) return 0;
        
        int left = height(node.left);
        if (left == -1) return -1;
        int right = height(node.right);
        if (right == -1) return -1;
        
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}
