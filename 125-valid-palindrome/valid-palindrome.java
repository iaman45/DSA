class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        StringBuilder str = new StringBuilder(s);

        return str.toString().equals(str.reverse().toString());
    }
}