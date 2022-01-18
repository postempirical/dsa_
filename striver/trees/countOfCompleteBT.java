class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if (left == right) return ((2<<(left)) - 1);
        else return countNodes(root.left) 
            + countNodes(root.right) + 1;
    }
    
    public int getLeftHeight(TreeNode root) {
        int h = 0;
        while(root.left != null) {
            h++;
            root = root.left;
        }
        return h;
    }
    
    public int getRightHeight(TreeNode root) {
        int h = 0;
        while (root.right != null) {
            h++;
            root = root.right;
        }
        return h;
    }
}
