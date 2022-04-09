// BFS
// just add the last value of each level
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) res.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return res;
    }
}

// DFS
// reverse preorder
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        rightview(root, ans, 0);
        return ans;
    }
    public void rightview(TreeNode node, List<Integer> ans, int level) {
        if (node == null) return;
        if (level == ans.size()) ans.add(node.val);
        rightview(node.right, ans, level + 1);
        rightview(node.left, ans, level + 1);
        // reverse calls for left view
    }
}
