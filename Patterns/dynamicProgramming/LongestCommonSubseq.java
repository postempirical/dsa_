// MEMOIZE
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int dp[][]=new int[n1][n2];
        return solve(n1 - 1, n2 - 1, text1, text2, dp);
    }
    
    private int solve(int ind1, int ind2, String text1, String text2, int[][] dp) {
        // return 0 if string finished
        if (ind1 < 0 || ind2 < 0) return 0;
        
        if (dp[ind1][ind2] != 0) return dp[ind1][ind2];
        // if letters match, move both index and add 1
        if (text1.charAt(ind1) == text2.charAt(ind2)) 
            return dp[ind1][ind2] = 1 + solve(ind1 - 1, ind2 - 1, text1, text2, dp);
        
        // if letter dont match, move one index at a time and MAX them
        return dp[ind1][ind2] = Math.max(solve(ind1 - 1, ind2, text1, text2, dp), 
                                         solve(ind1, ind2 - 1, text1, text2, dp));
    }
}

// TABULAR
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int dp[][]=new int[n1 + 1][n2 + 1];
        
        // right shifted indices so ind now becomes ind - 1
        
        // base case
        for (int ind1 = 0; ind1 <= n1; ind1++) dp[ind1][0] = 0;
        for (int ind2 = 0; ind2 <= n2; ind2++) dp[0][ind2] = 0;
        
        // loops in reverse
        for (int ind1 = 1; ind1 <= n1; ind1++) {
            for (int ind2 = 1; ind2 <= n2; ind2++) {
                // copy recurrence
                if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) // shift
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }
        return dp[n1][n2];
    }
}


// PRINGTING LCS
static void lcs(String s1, String s2) {
    
    int n=s1.length();
    int m=s2.length();

    int dp[][]=new int[n+1][m+1];
    for(int i=0;i<=n;i++){
        dp[i][0] = 0;
    }
    for(int i=0;i<=m;i++){
        dp[0][i] = 0;
    }
    
    for(int ind1=1;ind1<=n;ind1++){
        for(int ind2=1;ind2<=m;ind2++){
            if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
            else
                dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
        }
    }
    
    int len=dp[n][m];
    int i=n;
    int j=m;
    
    int index = len-1;
    String str="";
    for(int k=1; k<=len;k++){
        str +="$"; // dummy string
    }
	
    StringBuilder ss= new StringBuilder(s1);
    StringBuilder str2=new StringBuilder(str);
    while(i>0 && j>0){
        if(ss.charAt(i-1) == s2.charAt(j-1)){
            str2.setCharAt(index,ss.charAt(i-1) ); 
            index--;
            i--;
            j--;
        }
        else if(ss.charAt(i-1)>s2.charAt(j-1)){
            i--;
        }
        else j--;
    }
    System.out.println(str2);
}
