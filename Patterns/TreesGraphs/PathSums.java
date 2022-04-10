// PATH SUM 1
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        // if reached a leaf node, check if sum is equal to value
        if (root.left == null && root.right == null) return sum == root.val;
        
        // otherwise go to both branches recursively
        // calculate reamaining sum to pass instead of original sum
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}


// PATH SUM 2
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<>();
        findPath(root, targetSum, current, res);
        return res;
    }
    private void findPath(TreeNode node, int sum, 
                          List<Integer> current, List<List<Integer>> res) {
        if (node == null) return;
        current.add(node.val);
        // if leaf node and sum matches, add current list to res list
        if (node.left == null && node.right == null && sum == node.val)
            res.add(new ArrayList<Integer>(current));
        // else go to its left/right side with remainig sumt to hit
        findPath(node.left, sum - node.val, current, res);
        findPath(node.right, sum - node.val, current, res);
        // backtrack and remove last value
        current.remove(current.size() - 1);
    }
}


// PATH SUM 3

// naive
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumCalculate(root, sum) 
            + pathSum(root.left, sum)
            + pathSum(root.right, sum);
    }
    
    // this function actually calculates the sum from given head node
    // we need as path is NOT from root to leaf directly
    // then we call this on all nodes using pathsum(left/right)
    private int pathSumCalculate(TreeNode node, int sum) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == sum) count++;
        count += pathSumCalculate(node.left, sum - node.val);
        count += pathSumCalculate(node.right, sum - node.val);
        return count;
    }
}
