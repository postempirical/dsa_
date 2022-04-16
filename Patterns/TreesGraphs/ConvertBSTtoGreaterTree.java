// recursive
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        // in BST right is greater
        // add the node's value to sum
        // update node's value to sum
        // now go to the left
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}

// iterative


// morris
