class Solution {
    public int closedIsland(int[][] grid) {
        int i,j;
        int count = 0;

        for(i=0;i<grid.length;i++)
        {
            fill(grid,i,0);
            fill(grid,i,grid[0].length-1);
        }

        for(j=0;j<grid[0].length;j++)
        {
            fill(grid,0,j);
            fill(grid,grid.length-1,j);
        }

        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                {
                    count++;
                    fill(grid,i,j);
                }
            }
        }

        return count;
    }

    void fill(int[][] grid, int i, int j)
    {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length)
        {
            return;
        }

        if(grid[i][j]==1)
        {
            return;
        }
        grid[i][j] = 1;
        fill(grid,i-1,j);
        fill(grid,i+1,j);
        fill(grid,i,j-1);
        fill(grid,i,j+1);
    }
}