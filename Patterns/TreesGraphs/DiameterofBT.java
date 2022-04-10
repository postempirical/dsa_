/**
 * This can be difficult to understand, as maxDepth is a bit
 * of a cheeky function. MaxDepth is basically a simple height()
 * function, finding the height of a tree rooted at the given node.
 *
 * What makes it clever is as it is doing this, it is also
 * adding taking the computed heights of it's subtrees to find the
 * maximum diameter that passes through the given node as a root.
 * If this is the global maximum diameter, it updates the class member.
 */
public class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        // This will find the max depth going through each node,
        // and update the global maximum to the class member 'max'
        maxDepth(root);
        
        // Return the global maximum
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        // Height of null is 0
        if (root == null) {
            return 0;
        }
        
        // Find height of left and right subTrees
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        // New global max is either already reached,
        // or is acheived using this node as the root
        max = Math.max(max, left + right);
        
        // Return height of tree rooted at this node
        return Math.max(left, right) + 1;
    }
}
