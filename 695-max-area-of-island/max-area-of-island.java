class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int i, j;
        int max = 0;

        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[0].length;j++)
            {
                max = Math.max(max,maxArea(grid,i,j));
            }
        }

        return max;
    }

    int maxArea(int[][] grid, int i, int j)
    {
        if(i<0||i>=grid.length || j<0||j>=grid[0].length)
        {
            return 0;
        }
        int count = 0;

        if(grid[i][j]==0)
        {
            return 0;
        }
        else
        {
            grid[i][j] = 0;
        }

        count=1+maxArea(grid,i+1,j)+maxArea(grid,i-1,j)+maxArea(grid,i,j+1)+maxArea(grid,i,j-1);

        return count;
    }
}