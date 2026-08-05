class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] visited = new int[mat.length][mat[0].length];
        int rows = mat.length;
        int cols = mat[0].length;
        int i, j;
        LinkedList<int[]> queue = new LinkedList<>();

        int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        for(i=0;i<rows;i++)
        {
            for(j=0;j<cols;j++)
            {
                if(mat[i][j]==0)
                {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for(int[] dir : dirs)
            {
                int cx = x+dir[0];
                int cy = y+dir[1];

                if(cx<0 || cx>=rows || cy<0 || cy>=cols)
                {
                    continue;
                }

                if(mat[cx][cy]==1 && visited[cx][cy]==0)
                {
                    mat[cx][cy] = mat[x][y]+1;
                    queue.offer(new int[]{cx,cy});
                }

                visited[cx][cy] = 1;
            }
        }

        return mat;
    }
}