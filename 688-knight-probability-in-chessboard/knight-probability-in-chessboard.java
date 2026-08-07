class Solution {
    int[][] dir ={
        {-2,-1},{-2,1},
        {2,-1},{2,1},
        {-1,2},{-1,-2},
        {1,-2},{1,2}
    };
    double[][][] dp;
    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[n][n][k+1];
        return solve(n,k, row, column);
    }
    private double solve(int n, int k, int row,int column)
    {
        if(row<0|| row>=n|| column<0|| column>=n)
        {
            return 0.0;
        }
        if(k==0) return 1.0;
        
        if(dp[row][column][k]!=0.0) return dp[row][column][k];

        double ans=0.0;
        
        for(int[] d: dir)
        {
            ans+= solve(n,k-1,row+d[0],column+d[1])/8.0;
        }
        return dp[row][column][k]= ans;
    }
}