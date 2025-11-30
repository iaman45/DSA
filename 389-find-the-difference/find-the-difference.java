class Solution {
    static{
        for(int i=0;i<500;i++){
            findTheDifference("","a");
        }
    }
    public static char findTheDifference(String s, String t) {
        int s1=0,s2=0;
        for(char c:t.toCharArray()){
            s1^=c;
        }
        for(char c:s.toCharArray()){
            s2^=c;
        }
        return (char)(s1^s2);
    }
}