// https://leetcode.com/problems/binary-tree-maximum-path-sum/

class Solution {
    public int maxPathSum(TreeNode root) {
        int mx[] = new int[1];
        mx[0] = Integer.MIN_VALUE;
        maxpath(root, mx);
        return mx[0];
    }
    
    public int maxpath(TreeNode node, int[] mx) {
        if (node == null) return 0;
        
        int left = Math.max(0, maxpath(node.left, mx));
        int right = Math.max(0, maxpath(node.right, mx));
        
        mx[0] = Math.max(mx[0], left + right + node.val);
        return node.val + Math.max(left, right);
    }
}
