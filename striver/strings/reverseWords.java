class Solution {
    public String reverseWords(String s) {
        int start = 0; // pos for insertion
        char[] arr = s.toCharArray();
        
        // reverse sentence
        reverse(arr, 0, arr.length - 1);
        
        // reverse each word to get ans
        for (int i = 0; i < arr.length; i++) {
            // skip spaces
            if (arr[i] != ' ') {
                // put a blank space in front of the word 
                // if this word is not the first word
                if (start != 0) {
                    arr[start] = ' ';
                    start++;
                }
                // j for end  of word
                // i for start of word
                int j = i; 
                while (j < s.length() && arr[j] != ' ') {
                    arr[start] = arr[j];
                    start++;
                    j++;
                }
                reverse(arr, start - j + i, start - 1);
                i = j;
            }
        }
        return new String(arr, 0, start);
    }
    
    private void reverse(char[] arr, int begin, int end) {
        while(begin < end) {
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
    }
}
