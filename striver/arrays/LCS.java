// brute
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int max = 1;
        int len = 1;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i + 1] == nums[i] + 1) len++;
            else if (nums[i + 1] == nums[i]) continue;
            else len = 1;
            max = Math.max(max, len);
        }
        return max;
    }
}

// hashset
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i : nums) hashSet.add(i);
        int max = 0;
        for (int i : nums) {
            if (!hashSet.contains(i - 1)) {
                // int curr = i;
                int streak = i;
                while (hashSet.contains(streak)) { // instead of curr
                    // curr++;
                    streak++;
                }
                max = Math.max(max, streak - i);
            }
        }
        return max;
    }
}
