class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // since we need to ship each item, so we need capacity of atleast the heaviest item
        // otherwise we will never be able to ship it
        // also suppose we have just 1 day to ship => 
        // we need to ship all weight => sum of all items
        int left = weights[0], right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            // if we can ship current weight within given days
            // we try to minimise it by checking if can further decrease weight and still ship it
            if (isFeasible(mid, weights, days)) right = mid;
            
            // if we cannot ship the weight within given days
            // we need to increase weight that can be shipped on a single day
            else left = mid + 1;
        }
        return left;
    }
    
    // basically checks if we can somehow ship the weight given within given days
    private boolean isFeasible(int capacity, int[] weights, int days) {
        int day = 1; // initially shipping on day 1 
        int total = 0; // currently no weight shipped
        for (int w : weights) {
            total += w;
            // if we exceed capacity, we need to add rest of weights the next day
            // if somehow days become > alloted days, we cannot ship within time -> false
            if (total > capacity) {
                total = w; // store the current weight for next day starting
                day++;
                if (day > days) return false;
            }
        }
        return true;
    }
}
