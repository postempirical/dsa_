// o(n) space using hashmap
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // map containing parents of each node
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        trackParents(root, target, parents);
        
        // map to check if approached node is already visited
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        
        // start traversing from target node in all direction radially
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        
        // initial dis is 0
        int distance = 0;
        
        // queue wont be empty as it will break at k distance
        // the remaining values in queue would be the result
        while (!q.isEmpty()) {
            int size = q.size();
            if (distance == k) break;
            distance++;
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                
                // if L/R exists and is not visited
                if (curr.left != null && visited.get(curr.left) == null) {
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                q.add(curr.right);
                visited.put(curr.right, true);
                }
                
                // also check upwards 
                // parents.get(curr) returns parent of curr
                if (parents.get(curr) != null && visited.get(parents.get(curr)) == null) {
                    q.add(parents.get(curr));
                    visited.put(parents.get(curr), true);
                }
            }
        }
        
        // add answer to a list
        List<Integer> res = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            res.add(curr.val);
        }
        return res;
    }
    
    // function to keep track of parent of each node
    public void trackParents(TreeNode node, TreeNode target, Map<TreeNode, TreeNode> parents) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            // if left is not null
            // add parent to map and add left to queue
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

// without using hashmap
