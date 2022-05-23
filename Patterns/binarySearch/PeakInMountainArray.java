class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // peak index after mid
            if (arr[mid] < arr[mid + 1]) left = mid + 1;
            // peak index before mid
            else if (arr[mid] < arr[mid - 1]) right = mid;
            // peak found
            else return mid;
        }
        // no peak found
        return -1;
    }
}
