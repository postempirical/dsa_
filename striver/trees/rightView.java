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
        // do left first then right, for left view
    }
}
