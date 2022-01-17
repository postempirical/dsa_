class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return func(root.left, root.right);
    }
    
    public boolean func (TreeNode left, TreeNode right) {
        if (left == null || right == null) 
            return left == right;
        
        if (left.val != right.val) return false;
        
        return func(left.left, right.right) 
            && func(left.right, right.left);
    }
}
