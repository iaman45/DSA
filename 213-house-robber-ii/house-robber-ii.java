class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];

        int dp1[] = new int[n];
        int dp2[] = new int[n];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int case1= solve(n-2,nums,dp1,0);
        int case2= solve(n-1,nums,dp2,1);

        return Math.max(case1,case2);
    }
    public int solve(int i,int[] nums,int[] dp,int start)
    {
        if(i<start) return 0;
        if(dp[i]!=-1) return dp[i];

        int pick = nums[i] + solve(i-2,nums,dp,start);
        int notPick = solve(i-1,nums,dp,start);

        return dp[i] = Math.max(pick,notPick);
    }
}