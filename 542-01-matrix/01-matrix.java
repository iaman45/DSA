class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] dist = new int[row][col];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(mat[i][j]==0)
                {
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});
                }
                else 
                {
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty())
        {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d : dir)
            {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nc >=0 && nr<row && nc<col)
                {
                    if(dist[nr][nc]>dist[r][c]+1)
                    {
                        dist[nr][nc]=dist[r][c]+1;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return dist;
    }
}