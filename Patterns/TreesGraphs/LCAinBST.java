class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int curr = root.val;
        // if both p,q are greater than current value 
        // this means p,q lie on the right side, vice versa
        if (p.val > curr && q.val > curr) return lowestCommonAncestor(root.right, p, q);
        if (p.val < curr && q.val < curr) return lowestCommonAncestor(root.left, p, q);
				// if both of them are not on right or left
        // this means it is the first point of split
        return root;
    }
}
