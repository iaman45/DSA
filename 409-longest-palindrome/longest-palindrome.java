class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int ans = 0;
        boolean hasOdd = false;

        for (int f : freq) {
            if (f % 2 == 0) {
                ans += f;
            } else {
                ans += (f - 1);
                hasOdd = true;
            }
        }

        return hasOdd ? ans + 1 : ans;
    }
}
