import java.util.*;
class Solution {
    int ans=0;
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int n:nums)
        {
            maxHeap.add(n);
        }
        for(int i=0;i<k;i++)
        {
            ans=maxHeap.remove();
        }
        return ans;
    }
}