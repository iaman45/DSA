import java.util.Arrays;

class Solution {

    public static int uniquePaths(int i, int j,
                                  int[][] grid,
                                  int[][] dp) {

        if (i < 0 || j < 0) return 0;

        if (grid[i][j] == 1) return 0;   

        if (i == 0 && j == 0) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        int left = uniquePaths(i, j-1, grid, dp);
        int up   = uniquePaths(i-1, j, grid, dp);

        return dp[i][j] = left + up;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[m][n];

        for (int x = 0; x < m; x++) {
            Arrays.fill(dp[x], -1);
        }

        return uniquePaths(m-1, n-1, obstacleGrid, dp);
    }
}
