class Solution {
    public int reverse(int x) {
        boolean minus = false;
        int temp = 0, result = 0;
        while (x != 0) {
            int last = x % 10;
            temp = result * 10 + last;
            
            if ((temp - last) / 10 != result) return 0;
            result = temp;
            x = x / 10;
        }
        return result;
    }
}
