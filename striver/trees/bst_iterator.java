class BSTIterator {
    Stack<TreeNode> st = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp = st.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    public void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
}
