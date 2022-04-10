class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // if both null return null
        // otherwise return the non null value
        if (root1 == null && root2 == null) return null;
        else if (root1 == null) return root2;
        else if (root2 == null) return root1;
        
        // create new node with values sum
        // this will be the head of new tree
        TreeNode node = new TreeNode();
        node.val = root1.val + root2.val;
        // dfs on left right branches
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}
