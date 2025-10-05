class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3]; // index 0 -> 'a', 1 -> 'b', 2 -> 'c'
        int left = 0;
        int result = 0;

        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;

        
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // all substrings starting at left and ending at >= right are valid
                result += (n - right);

                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return result;
    }
}
