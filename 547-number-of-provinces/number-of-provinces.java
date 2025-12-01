class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean isVisited[] = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!isVisited[i])
            {
                dfs(isConnected,isVisited,i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected,boolean[] isVisited,int start)
    {
        isVisited[start]=true;
        for(int j=0;j<isConnected.length;j++)
        {
            if(isConnected[start][j]==1 && !isVisited[j])
            {
                dfs(isConnected,isVisited,j);
            }
        }
    }
}