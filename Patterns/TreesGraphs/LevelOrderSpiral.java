class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if (root == null) return wrapList;
        q.add(root);
        // take a zigzag to check for direction to insert
        boolean zigzag = false;
        
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();  
                
                // add according to zigzag
                if (zigzag) levelList.add(0, node.val);  
                else levelList.add(node.val); 
                
                if (node.left != null) q.add(node.left);  
                if (node.right != null) q.add(node.right);  
            }
            wrapList.add(levelList);
            zigzag = !zigzag; // flip zigzag
        }
        return wrapList;
    }
}
