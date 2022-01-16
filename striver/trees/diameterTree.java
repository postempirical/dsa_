class Solution {
    int mx = 0;
    // can also create and array m[0]
    // and pass it along with height func
    // if we dont wanna use global
    
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return mx;
    }
    
    public int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        mx = Math.max(mx, left + right);
        return 1 + Math.max(left, right);
    }
}
