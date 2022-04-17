class Solution {
    private TreeNode newRoot;
    private TreeNode prev;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        inorder(root);
        return newRoot;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        
        // when we reach the leftmost node,
        // and newRoot is still empty, update newRoot to it
        // this will be the new head of output tree
        
        // otherwise point prev to node
        if (newRoot == null) newRoot = node;
        else prev.right = node;
        
        // bring prev on node
        // and make left of node null
        prev = node;
        node.left = null;
        
        // now go to the right branch
        inorder(node.right);
    }
}
