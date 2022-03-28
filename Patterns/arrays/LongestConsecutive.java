class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        
        int max_streak = 0;
        for (int i : nums) {
            // get start of streak
            if (!set.contains(i - 1)) {
                int curr = i;
                int streak = 1;
                
                // update till consetcutive vals found
                while (set.contains(curr + 1)) {
                    curr++; streak++;
                }
                
                // store max after streak break
                max_streak = Math.max(max_streak, streak);
            }
        }
        return max_streak;
    }
}
