
// o(n) 0(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        // 01-02-03-04 = nums
        // 01-01-02-06 = left
        // 24-12-04-01 = right
        // 24-12-08-06 = result
        
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        for (int i = 0; i < product.length; i++) {
            product[i] = left[i] * right[i];
        }
        
        return product;
    }
}

// o(n) o(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {        
        // 01-02-03-04 = nums
        // 01-01-02-06 = res(left)
        // 24-12-04-01 = prod
        // 24-12-08-06 = result(final)
        
        int[] res = new int[nums.length];
        
        // store left products in res array initially
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        // product of numbers to the right of current element.
        int prod = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            prod = prod * nums[i + 1];
            res[i] *= prod;
        }
        
        return res;
    }
}
