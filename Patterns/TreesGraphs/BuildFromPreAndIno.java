class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // store inorder values in a map
        HashMap<Integer, Integer> ino_map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) ino_map.put(inorder[i], i);
        
        TreeNode root = create(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1, ino_map);
        return root;
    }
    
    private TreeNode create(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inoStart, int inoEnd, 
                           HashMap<Integer, Integer> ino_map) {
        // base
        if (preStart > preEnd || inoStart > inoEnd) return null;
        
        // start of pre will be the root 
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // find out position of above root in inorder map
        int inoRoot = ino_map.get(root.val);
        
        // find out total items on the left of ino root
        int numLeft = inoRoot - inoStart;
        
        // LEFT
        // pre will start from prestart + 1 till prestart + numLeft
        // ino will start from inostart till inoRoot - 1
        root.left = create(preorder, preStart + 1, preStart + numLeft,
                    inorder, inoStart, inoRoot - 1, ino_map);
        
        // RIGHT
        // pre will go from (prestart + numleft) + 1 till preEnd
        // ino will go from inoRoot + 1 till inoEnd
        root.right = create(preorder, preStart + numLeft + 1, preEnd,
                           inorder, inoRoot + 1, inoEnd, ino_map);
        return root;
    }
}
