class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> spiral = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) return spiral;
        boolean zig = true;
        q.offer(root);
        while (!q.isEmpty()) {
            int x = q.size();
            ArrayList<Integer> sublist = new ArrayList<Integer>();
            for (int i = 0; i < x; i++) {
                TreeNode node = q.poll();
                if (zig == true) sublist.add(node.val);
                else sublist.add(0, node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            spiral.add(sublist);
            zig = !zig;
        }
        return spiral;
    }
}
