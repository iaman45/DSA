import java.util.*;
class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] x:dp)
        {
            Arrays.fill(x,-1);
        }
        return LCS(s1.length()-1, s2.length()-1, s1,s2,dp);
    }
    public int LCS(int i, int j, String s1, String s2, int[][]dp)
    {
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = 1+ LCS(i-1,j-1,s1,s2,dp);
        return dp[i][j] = 0+  Math.max(LCS(i,j-1,s1,s2,dp),LCS(i-1,j,s1,s2,dp));
    }
}