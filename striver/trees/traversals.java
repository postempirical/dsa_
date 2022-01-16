// LEVEL ORDER
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> wrap = new ArrayList<List<Integer>>();
        if (root == null) return wrap;
        q.offer(root);
        while (!q.isEmpty()) {
            int x = q.size();
            ArrayList<Integer> sublist = new ArrayList<Integer>();
            for (int i = 0; i < x; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                sublist.add(q.poll().val);
            }
            wrap.add(sublist);
        }
        return wrap;
    }
}


// INORDER ITR
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // Iterative
        List<Integer> ino = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        if (root == null) return ino;
        while (true) {
            if (root != null) {
                st.push(root);
                root = root.left;
            }
            else {
                if (st.isEmpty()) break;
                root = st.pop();
                ino.add(root.val);
                root = root.right;
            }
        }
        return ino;
    }
}


// PREORDER ITR
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // Iterative
        List<Integer> pre = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        if (root == null) return pre;
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            pre.add(root.val);
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }
        return pre;
    }
}


// POSTORDER ITR
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st_one = new Stack<TreeNode>();
        Stack<TreeNode> st_two = new Stack<TreeNode>();
        List<Integer> post = new ArrayList<Integer>();
        if (root == null) return post;
        st_one.push(root);
        while (!st_one.isEmpty()) {
            root = st_one.pop();
            st_two.push(root);
            if (root.left != null) st_one.push(root.left);
            if (root.right != null) st_one.push(root.right);
        }
        while (!st_two.isEmpty()) {
            post.add(st_two.pop().val);
        }
        return post;
    }
}
