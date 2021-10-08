// [1]
class Solution {
    public void sortColors(int[] nums) {
        int count_one = 0, count_two = 0, count_zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count_zero++;
            else if (nums[i] == 1) count_one++;
            else if (nums[i] == 2) count_two++;
        }
        
        for (int i = 0; i < count_zero; i++) nums[i] = 0;
        for (int i = 0; i < count_one; i++) nums[count_zero+i] = 1;
        for (int i = 0; i < count_two; i++) nums[count_zero+count_one+i] = 2;
    }
}

// [2]

class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        int temp;
        while (mid <= high) {
            if (nums[mid] == 0) {
                temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
