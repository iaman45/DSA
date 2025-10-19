import java.util.*;
class Solution {
    public void generateAll(int n,String current,int open, int close, List<String> result)
    {
        if(current.length()==2*n)
        {
            result.add(current);
            return;
        }
        if(open<n)
        {
            generateAll(n,current+"(",open+1,close, result);
        }
        if(close<open)
        {
            generateAll(n,current+")",open,close+1, result);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(n,"",0,0,result);
        return result;
    }
}