class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        StringBuilder str = new StringBuilder(s);

        if (str.toString().equals(str.reverse().toString())) {
            return true;
        }

        return false;
    }
}