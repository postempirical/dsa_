class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] nums, int start, int end) {
        // base case
        if (start > end) return null;
        // take first element as max
        int maxIndex = start;
        
        // now find actual max value's index
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        
        // create head root with this max 
        TreeNode root = new TreeNode(nums[maxIndex]);
        // for left go from start till before max index
        root.left = build(nums, start, maxIndex - 1);
        // for right go from after max index to end
        root.right = build(nums, maxIndex + 1, end);
        
        return root;
    }
}
