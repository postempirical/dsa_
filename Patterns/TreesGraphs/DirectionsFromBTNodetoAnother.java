class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // get LCA of start and destination node
        TreeNode lca = getLCA(root, startValue, destValue);
        
        // create 2 path strings
        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();
        
        // get path of (lca to start) and (lca to dest)
        getPath(lca, startValue, lcaToStart);
        getPath(lca, destValue, lcaToDest);
        
        // whatever we get in lcaToStart
        // convert it all to U, as we have to always go up to LCA
        String startToLca = "U";
        startToLca = startToLca.repeat(lcaToStart.length());
        
        // combine startToLca and lcaToDest
        return startToLca + lcaToDest.toString();
    }
    
    // GET LEAST COMMON ANCESTOR
    private TreeNode getLCA(TreeNode root, int a, int b) {
        if (root == null || root.val == a || root.val == b) return root;
        
        TreeNode left = getLCA(root.left, a, b);
        TreeNode right = getLCA(root.right, a, b);
        
        if (left != null && right != null) return root;
        
        return left == null ? right : left;
    }
    
    // GET PATH FROM LCA TO START/DEST
    private boolean getPath(TreeNode begin, int end, StringBuilder path) {
        if (begin == null) return false;
        
        // if node found, we have our path already
        // so simply return true and go no further
        if (begin.val == end) return true;
        
        // try to find pat in left direction
        // if found return true, else backtrack and remove
        path.append("L");
        if(getPath(begin.left, end, path)) return true;
        path.deleteCharAt(path.length() - 1);
        
        // similarly for right direction
        path.append("R");
        if(getPath(begin.right, end, path)) return true;
        path.deleteCharAt(path.length() - 1);
        
        // if node not found in both direction, return false
        return false;
    }
}
