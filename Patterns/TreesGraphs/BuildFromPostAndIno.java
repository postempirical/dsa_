class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // store inorder values in a map
        HashMap<Integer, Integer> ino_map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) ino_map.put(inorder[i], i);
        
        TreeNode root = create(postorder, 0, postorder.length - 1,
                    inorder, 0, inorder.length - 1, ino_map);
        return root;
    }
    
    private TreeNode create(int[] postorder, int postStart, int postEnd,
                           int[] inorder, int inoStart, int inoEnd, 
                           HashMap<Integer, Integer> ino_map) {
        // base
        if (postStart > postEnd || inoStart > inoEnd) return null;
        
        // last value of post will be the root 
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        // find out position of above root in inorder map
        int inoRoot = ino_map.get(root.val);
        
        // find out total items on the left of ino root
        int numLeft = inoRoot - inoStart;
        
        // LEFT
        // post will start from postStart till postStart + numLeft - 1
        // ino will start from inostart till inoRoot - 1
        root.left = create(postorder, postStart, postStart + numLeft - 1,
                    inorder, inoStart, inoRoot - 1, ino_map);
        
        // RIGHT
        // post will go from (postStart + numleft) + 1 till postEnd
        // ino will go from inoRoot + 1 till inoEnd
        root.right = create(postorder, postStart + numLeft, postEnd - 1,
                           inorder, inoRoot + 1, inoEnd, ino_map);
        return root;
    }    
    
}
