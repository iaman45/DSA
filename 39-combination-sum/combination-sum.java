import java.util.List;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),result);
        return result;
    }
    public static void backtrack(int[] candidates,int target, int start, List<Integer> tempList, List<List<Integer>> result)
    {
        if(target==0)
        {
            result.add(new ArrayList<>(tempList));
        }
        if(target<0) return;
        for(int i=start;i<candidates.length;i++)
        {
            tempList.add(candidates[i]);
            backtrack(candidates,target-candidates[i],i,tempList,result);
            tempList.remove(tempList.size()-1);
        }
    }
}