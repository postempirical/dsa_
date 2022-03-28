
o(n) 0(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        
        int[] product = new int[nums.length];
        for (int i = 0; i < product.length; i++) {
            product[i] = left[i] * right[i];
        }
        
        return product;
    }
}

// o(n) o(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pre_left = 1;
        
        for (int i = 0; i < nums.length; i++) {
            pre_left *= nums[i];
            res[i] = pre_left;
        }
        
        int post_right = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            res[i] = res[i - 1] * post_right;
            post_right *= nums[i];
        }
        
        res[0] = post_right;
        return res;
    }
}
