class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        getMax(root);
        return max;
    }
    public int getMax(TreeNode node) {
        if (node == null) return 0;
        // if we get a neg num from any side, just put 0 instead
        int leftSum = Math.max(0, getMax(node.left));
        int rightSum = Math.max(0, getMax(node.right));
        
        // calculate max sum
        int sum = node.val + leftSum + rightSum;
        max = Math.max(max, sum);
        
        // go path that will get max sum
        // the larger of left or right will be the desired path
        return node.val + Math.max(leftSum, rightSum);
    }
}
