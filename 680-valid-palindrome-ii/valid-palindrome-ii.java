class Solution {

   public static boolean val(String s, int left, int high) {
        while (left < high) {
            if (s.charAt(left) != s.charAt(high))
            {
                return false;
            }
            left++;
            high--;
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int high = n - 1;

        while (left < high) {
            if (s.charAt(left) != s.charAt(high)) {
                return val(s, left + 1, high) || val(s, left, high - 1);
            }
            left++;
            high--;
        }

        return true;
    }
};