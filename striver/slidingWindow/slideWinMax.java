class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int begin = 0, end = 0;
        
        while (end < nums.length) {
            // if empty just add to q
            // else keep removing smaller vals from the tail 
            // and then insert in the dq
            // this way head of dq will always be max
            if (dq.isEmpty()) dq.add(nums[end]);
            else {
                while (dq.size() > 0 && dq.peekLast() < nums[end])
                    dq.removeLast();
                dq.add(nums[end]);
            }
            
            // window size achieved 
            if (end - begin + 1 == k) {
                // add front of dq to res
                res[begin] = dq.peekFirst();
                
                // sliding
                // remove front of dq if its equal to begin value
                if (dq.peekFirst() == nums[begin]) dq.removeFirst();
                begin++;
            }
            end++;
        }
        return res;
    }
}
