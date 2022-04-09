// BFS 
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // at least 1 node so min depth is 1
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                // if we reached a leaf node return depth
                if (node.left == null && node.right == null)
                    return depth;
                // else just add left right nodes
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            // we ascended a level so inc depth
            depth++;
        }
        return depth;
    }
}


// DFS
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)	return 0;
	      if (root.left == null)	return minDepth(root.right) + 1; // leaf nodes are in right subtree
      	if (root.right == null) return minDepth(root.left) + 1; // leaf nodes are in left subtree
	      return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}


// BFS is much better here, rather than a DFS approach.
// Sure, the solution here is short in terms of lines of code and looks nice, but it's far from optimal.
// If you have a tree where say the root's left subtree has a depth of 500 and the right subtree has a depth of 1, 
// the code is going to traverse all the way down the 500 left subtree first before finally traversing the right subtree 
// with a measly depth of 1 and figuring out "d'oh!" that's the min depth.
// With BFS, instead of traversing 501 nodes to figure out the min depth, 
// you could've just traversed two. Now imagine if the left subtree comprised of tens of thousands of nodes ...
