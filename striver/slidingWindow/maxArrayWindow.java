// https://leetcode.com/problems/sliding-window-maximum/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] max_array = new int[nums.length - k + 1];
        int i = 0, j = 0;
        
        while (j < nums.length) {
            // if empty just add to q
            // else keep removing smaller vals from end
            // and then insert in the end
            // this way head of q will always be max
            if (q.isEmpty()) q.add(nums[j]);
            else {
                while (q.size() > 0 && q.peekLast() < nums[j]) 
                    q.removeLast();
                q.add(nums[j]);
            }
            
            if (j - i + 1 == k) {
                max_array[i] = q.peek();
                
                // sliding
                // if val are same we need new max in next iteration
                // so remove the head of queue
                if (q.peek() == nums[i]) q.removeFirst();
                i++;
            } 
            j++;
        }
        return max_array;
    
