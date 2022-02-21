// inorder + 2 pointers
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for (int i = 0, j = nums.size() - 1; i < j;) {
            if (nums.get(i) + nums.get(j) == k) return true;
            if(nums.get(i) + nums.get(j) < k) i++;
            else j--;
        }
        return false;
    }
    
    public void inorder(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
    }
}


//
