class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int min = 1;
        int max = grid.length*grid.length;
        int i, j;
        HashSet<Integer> set = new HashSet<>();
        for(i=min;i<=max;i++)
        {
            set.add(i);
        }
        int[] ans = new int[2];
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[0].length;j++)
            {
                if(!set.contains(grid[i][j]))
                {
                    ans[0] = grid[i][j];
                    continue;
                }
                set.remove(grid[i][j]);
            }
        }
        for(int num : set)
        {
            ans[1] = num;
            break;
        }
        return ans;
    }
}