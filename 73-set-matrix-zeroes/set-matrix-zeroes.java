class Solution {
    public void setZeroes(int[][] matrix) {
        int i,j;
        HashSet<Integer> xVals = new HashSet<>();
        HashSet<Integer> yVals = new HashSet<>();

        for(i=0;i<matrix.length;i++)
        {
            for(j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    xVals.add(i);
                    yVals.add(j);
                }
            }
        }

        for(i=0;i<matrix.length;i++)
        {
            for(j=0;j<matrix[0].length;j++)
            {
                if(xVals.contains(i) || yVals.contains(j))
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}