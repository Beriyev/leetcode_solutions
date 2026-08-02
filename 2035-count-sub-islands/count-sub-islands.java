class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int i, j;
        boolean valid = true;
        int count = 0;

        for(i=0;i<grid2.length;i++)
        {
            for(j=0;j<grid2[0].length;j++)
            {
                valid = true;
                if(grid2[i][j]==1&&valid&&fill(grid1,grid2,i,j))
                {
                    count++;
                }
            }
        }

        return count;
    }

    boolean fill(int[][] grid1, int[][] grid2, int i, int j)
    {
        if(i<0||i>=grid2.length||j<0||j>=grid2[0].length)
        {
            return true;
        }
        boolean validity;
        if(grid2[i][j]==0)
        {
            return true;
        }
        if(grid1[i][j]==0&&grid2[i][j]==1)
        {
            grid2[i][j] = 0;
            validity = false;
        }
        else
        {
            grid2[i][j] = 0;
            validity = true;
        }
        boolean a = fill(grid1,grid2,i+1,j);
        boolean b = fill(grid1,grid2,i-1,j);
        boolean c = fill(grid1,grid2,i,j+1);
        boolean d = fill(grid1,grid2,i,j-1);
        return validity&&a&&b&&c&&d;
    }
}