class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[2];
        int i,j;
        int lo = 0;
        int hi = n-1;
        int highest = -1;
        int highrow = 0;
        int left = 0;
        int right = 0;
        int mid;

        while(lo<=hi)
        {
            mid = (lo+hi)/2;
            highest = -1;
            for(i=0;i<m;i++)
            {
                if(mat[i][mid]>highest)
                {
                    highest = mat[i][mid];
                    highrow = i;
                }
            }

            if(mid==0&&mid==n-1)
            {
                left = -1;
                right = -1;
            }
            else if(mid==0&&mid<n-1)
            {
                left = -1;
                right = mat[highrow][mid+1];
            }
            else if(mid==n-1&&mid>0)
            {
                right = -1;
                left = mat[highrow][mid-1];
            }
            else if(mid>0&&mid<n-1)
            {
                left = mat[highrow][mid-1];
                right = mat[highrow][mid+1];
            }

            if(mat[highrow][mid]>left&&mat[highrow][mid]>right)
            {
                ans[0] = highrow;
                ans[1] = mid;
                return ans;
            }
            else if(mat[highrow][mid]<left)
            {
                if(mid>0)
                {
                    hi = mid-1;
                }
            }
            else if(mat[highrow][mid]<right)
            {
                if(mid<n-1)
                {
                    lo = mid+1;
                }
            }
        }
        return ans;
    }
}