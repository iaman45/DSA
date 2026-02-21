class Solution {
    public int pivotIndex(int[] nums) {
        int total=0;
        int len=nums.length;
        for(int i=0;i<len;i++)
        {
            total+=nums[i];
        }
        int leftSum=0;
        int rightSum=0;
        for(int i=0;i<len;i++)
        {
            rightSum=total-leftSum-nums[i];
            if(leftSum==rightSum) return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}