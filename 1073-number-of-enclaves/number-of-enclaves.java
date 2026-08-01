class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        int i,j;

        for(i=0;i<grid.length;i++)
        {
            num(grid,i,0);
            num(grid,i,grid[0].length-1);
        }

        for(j=0;j<grid[0].length;j++)
        {
            num(grid,0,j);
            num(grid,grid.length-1,j);
        }

        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
            }
        }

        return count;
    }

    void num(int[][] grid, int i, int j)
    {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length)
        {
            return;
        }

        if(grid[i][j]==0)
        {
            return;
        }

        grid[i][j] = 0;

        num(grid,i-1,j);
        num(grid,i+1,j);
        num(grid,i,j+1);
        num(grid,i,j-1);
    }
}