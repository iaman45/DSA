class Solution {
    public static void moveZeroes(int[] nums) {
        int a=0;
        int n = nums.length;
        for(int i=0; i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                continue;
            }
            else 
            {
                nums[a]=nums[i];
                a++;
            }
        }
        for(int i=a;i<n;i++)
        {
            nums[i]=0;
        }
    }
        public static void printArray(int[] nums)
        {
            int i =0;
            while(i<nums.length)
            {
                System.out.print(nums[i]+" ");
            }
            System.out.println();
        }
    public static void main(String[] args)
    {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        printArray(nums);
    }
}