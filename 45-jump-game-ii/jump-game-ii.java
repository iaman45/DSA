class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int curEnd=0;
        int maxEnd=0;
        for(int i=0;i<nums.length-1;i++)
        {
            maxEnd= Math.max(maxEnd,i+nums[i]);
            if(i==curEnd)
            {
                jumps++;
                curEnd=maxEnd;
            }
        }
        return jumps;
    }
}