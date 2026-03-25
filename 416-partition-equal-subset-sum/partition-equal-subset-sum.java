class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n: nums) sum+=n;
        if(sum%2!=0) return false;

        int target = sum/2;
        int[][] dp = new int[nums.length][target+1];
        for(int[] x:dp) Arrays.fill(x,-1);
        boolean ans = check(nums.length-1,target,nums,dp);
        return ans;
    }
public static boolean check(int index,int target,int[]nums,int[][] dp)
{
    if(target==0) return true;
    if(index==0) return target == nums[index];

    if(dp[index][target]!=-1) return dp[index][target]==1;

    boolean nTake=check(index-1,target,nums,dp);
    
    boolean take = false;
    if(nums[index]<=target)
    {
        take = check(index-1,target - nums[index],nums,dp);
    }
    dp[index][target] = nTake || take ? 1:0;
    return take||nTake;
}
}