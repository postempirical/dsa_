// approac 1
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        // 45 -> lies between squares of 6 and 7
        // so 6 must be <= 45 / 6 and 7 must be > 45 / 7 
        // this is the critical point we need to find
        for (int i = 1; i <= x / i; i++) {
            if (i <= x / i && (i + 1) > x / (i + 1)) return i;
        }
        return -1;
    }
}


// approach 2 (binary search
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) // Found the result
                return mid; 
            else if (mid > x / mid) // Keep checking the left part
                right = mid;
            else
                left = mid + 1; // Keep checking the right part
        }
        return left;
    }
}
