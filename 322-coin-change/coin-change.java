import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Fill dp with -1 using Arrays.fill
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = minCoins(coins, n - 1, amount, dp);
        return ans >= Integer.MAX_VALUE ? -1 : ans;
    }

    public static int minCoins(int[] coins, int index, int amount, int[][] dp) {

        // BASE CASE
        if (index == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            else
                return Integer.MAX_VALUE;
        }

        // MEMOIZATION CHECK
        if (dp[index][amount] != -1)
            return dp[index][amount];

        // NOT TAKE
        int notTake = minCoins(coins, index - 1, amount, dp);

        // TAKE
        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int sub = minCoins(coins, index, amount - coins[index], dp);
            if (sub != Integer.MAX_VALUE) {
                take = 1 + sub;
            }
        }

        // STORE RESULT
        dp[index][amount] = Math.min(take, notTake);
        return dp[index][amount];
    }
}
