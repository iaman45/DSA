class Solution {
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax= new int[n];
        int[] rightMax = new int[n];
        int amtwater=0;
        if(n==0) return 0;
        leftMax[0]=height[0];
        for(int i=1;i<n;i++)
        {
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }
        for(int i=0;i<n;i++)
        {
           int x = Math.min(leftMax[i],rightMax[i]);
           if(x>height[i])
           {
            amtwater += x - height[i];
           }
        }
        return amtwater;
    }
    public static void main(String[] args)
    {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trap(height));
    }
}   