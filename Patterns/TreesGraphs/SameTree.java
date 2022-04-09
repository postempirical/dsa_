class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case, also handles if given two empty trees
        if (p == null && q == null) return true;
        // if only one is null, they are not identical
        if (p == null || q == null) return false;
        
        // val is equal, recursivly call left, right branches 
        // all calls must return true
        if (p.val == q.val) 
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
