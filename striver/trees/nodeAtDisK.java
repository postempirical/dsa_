class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        // pass values to parent tracker function
        parents(root, target, parents);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        vis.put(target, true);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int dis = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            if (dis == k) break;
            dis++;
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                // if left exists and its not yet visited
                if (curr.left != null 
                    && vis.get(curr.left) == null) {
                    q.add(curr.left);
                    vis.put(curr.left, true);
                }
                if (curr.right != null 
                    && vis.get(curr.right) == null) {
                    q.add(curr.right);
                    vis.put(curr.right, true);
                }
                // parents.get(curr) returns parent of curr
                if (parents.get(curr) != null 
                    && vis.get(parents.get(curr)) == null) {
                    q.add(parents.get(curr));
                    vis.put(parents.get(curr), true);
                }
            }
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            ans.add(curr.val);
        }
        return ans;
    }
    
    
    // function to track parents of each node
    public void parents(TreeNode node, TreeNode target, 
        Map<TreeNode, TreeNode> parents) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                // curr is a parent of curr.left
                parents.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parents.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
}
