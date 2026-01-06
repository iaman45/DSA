class Solution {
    public String convert(String s, int numRows) {
    if(numRows==1 || numRows>=s.length()) return s;  

    StringBuilder ans = new StringBuilder();
    int cycle = (numRows-1)*2;

    for(int i=0;i<numRows;i++)
    {
        for(int j=i;j<s.length();j+=cycle)
        {
            ans.append(s.charAt(j));

            int diag = j+cycle-2*i;
            if(i!=0 && i!=numRows-1 && diag<s.length())
            {
                ans.append(s.charAt(diag));
            }
        }
    } 
    return ans.toString();
    }
}