import java.util.Stack;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[] = new int[10001];//because in the question constraints is given
        Stack<Integer> st = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<= nums2[i])
            {
                st.pop();
            }
            result[nums2[i]]=st.isEmpty() ? -1:st.peek();
            st.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++)
        {
            nums1[i]=result[nums1[i]];
        }
        return nums1;
    }
}