class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if(root == null) return wrapList;
        q.add(root);
        
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();  
                levelList.add(node.val);  
                if (node.left != null) q.add(node.left);  
                if (node.right != null) q.add(node.right);  
            }
            wrapList.add(levelList);
            // for Level Order 2 on Leetcode
            // wrapList.add(0, levelList);
        }
        return wrapList;
    }
}
