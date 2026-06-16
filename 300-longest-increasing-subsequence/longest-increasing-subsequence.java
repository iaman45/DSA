class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, -1, nums, n, dp);
    }

    private int solve(int index, int prevIndex,
                      int[] nums, int n, int[][] dp) {

        if (index == n) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int notTake = solve(index + 1, prevIndex, nums, n, dp);

        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + solve(index + 1, index, nums, n, dp);
        }

        return dp[index][prevIndex + 1] =
                Math.max(take, notTake);
    }
}