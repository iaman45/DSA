import java.util.HashSet;
class Solution {
    public int longestBalanced(int[] nums) {
        int ans=0;
for (int i = 0; i < nums.length; i++) {
    Set<Integer> evens = new HashSet<>();
    Set<Integer> odds  = new HashSet<>();

    for (int j = i; j < nums.length; j++) {
        if (nums[j] % 2 == 0) {
            evens.add(nums[j]);  
        } else {
            odds.add(nums[j]);  
        }

        if (evens.size() == odds.size()) {
            ans = Math.max(ans, j - i + 1); 
        }
    }
}
return ans;

    }
}