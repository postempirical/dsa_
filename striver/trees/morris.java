class Solution {
    // INORDER
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>(); 
        
        TreeNode cur = root; 
        while(cur != null) {
            if(cur.left == null) {
                inorder.add(cur.val); 
                cur = cur.right; 
            }
            else {
                TreeNode prev = cur.left; 
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right; 
                }
                
                if(prev.right == null) {
                    prev.right = cur;
                    // PREORDER _ ADD HERE INSTEAD OF BELOW
                    cur = cur.left; 
                }
                else {
                    prev.right = null; 
                    inorder.add(cur.val); 
                    cur = cur.right; 
                }
            }
        }
        return inorder; 
    }
}
