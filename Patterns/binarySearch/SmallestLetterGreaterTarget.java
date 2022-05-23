class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // like ceil of array element
        // but always return smallest next greater
        
        // if target is greater than all chars, return first char
        if (target >= letters[letters.length - 1]) return letters[0];
        
        int left = 0, right = letters.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // if target > mid, value is on right half
            if (target >= letters[mid]) left = mid + 1;
            else right = mid;
        }
        return letters[right];
    }
}
