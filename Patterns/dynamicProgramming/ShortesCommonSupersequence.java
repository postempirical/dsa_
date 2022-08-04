class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        // LONGEST COMMON SUBSEQUENCE
        int n1 = str1.length(), n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        
        for (int i = 0; i <= n1; i++) dp[i][0] = 0;
        for (int j = 0; j <= n2; j++) dp[0][j] = 0;
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        // NOW WE WORK ON SCS PART
        int len = dp[n1][n2];
        int i = n1, j = n2;
        // int index = len - 1;
        String res = "";
        
        while (i > 0 && j > 0) {
            // if letters match, move both
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res += str1.charAt(i - 1);
                // index--;
                i--; 
                j--;
            }
            // otherwise move towards greater 
            else if (dp[i -1][j] > dp[i][j - 1]) {
                res += str1.charAt(i - 1);
                i--;
            }
            else {
                res += str2.charAt(j - 1);
                j--;
            }
        }
        
        while (i > 0) {
            res += str1.charAt(i - 1);
            i--;
        }
        
        while (j > 0) {
            res += str2.charAt(j - 1);
            j--;
        }
        
        // reverse the string and return
        String result = new StringBuilder(res).reverse().toString();
        return result;
    }
}
