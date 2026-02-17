import java.util.HashMap;
class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer,Integer> key = new HashMap<>();
        HashMap<Integer,Integer> value = new HashMap<>();

        for(int[] t: trust)
        {
            key.put(t[0],key.getOrDefault(t[0],0)+1);
            value.put(t[1],value.getOrDefault(t[1],0)+1);
        }
        for(int i=1;i<=n;i++)
        {
            if(value.getOrDefault(i,0)==n-1 && key.getOrDefault(i,0)==0) return i;
        }
        return -1;
    }
}