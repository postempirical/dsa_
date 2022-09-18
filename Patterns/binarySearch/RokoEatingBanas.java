class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // LIKE LEETCODE 1011 - SHIPPIN PACKAGES IN D DAYS
        
        // create search space
        // lowerbound = 1 -> can decide to eat atleast 1 banana 
        // upperbound = max -> can decide to eat the entire largest pile
        int left = 1, right = piles[0];
        for (int pile : piles) right = Math.max(right, pile);
        
        // apply binary search on the search space
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (isFeasible(mid, piles, h)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    
    // create feasibility function
    private boolean isFeasible(int k, int[] piles, int h) {
        int hourCount = 0; // no banana eaten yet
        for (int pile : piles) {
            // pile = 20 bananas, can eat 5 an hour => total hours = (20/5) = 4
            int div = pile / k;
            hourCount += div;
            
            // pile = 23 bananas, can eat 5 an hour => need 1 extra hour for remaining 3
            if(pile % k != 0) hourCount++;
            if (hourCount > h) return false;
        }
        return true;
    }
}
